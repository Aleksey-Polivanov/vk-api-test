package alex.pol.domain;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

public class VkApi {

    private static final String AUTH_URL = "https://oauth.vk.com/authorize?" +
            "client_id={APP_ID}" +  // ID приложения
            "&scope={PERMISSIONS}" + // права доступа
            "&redirect_uri={REDIRECT_URI}" + // куда будет перенаправлен после авторизации
            "&display={DISPLAY}" +
            "&v={API_VERSION}" +
            "&response_type=token";

    private static final String API_REQUEST = "https://api.vk.com/method/{METHOD}?{PARAMS}&access_token={TOKEN}&v=5.21";

    public VkApi with(String appId, String accessToken) throws IOException {
        return new VkApi(appId, accessToken);
    }

    private final String accessToken;


    public VkApi(String appId, String accessToken) throws IOException {
        this.accessToken = accessToken;
        if (accessToken == null || accessToken.isEmpty()) {
            auth(appId);

            throw new Error("Need access token");
        }
    }

    private static void auth(String appId) throws IOException {
        String reqUrl = AUTH_URL
                .replace("{APP_ID}", appId)
                .replace("{PERMISSIONS}", "messages")
                .replace("{REDIRECT_URI}", "/methods")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", "5.21");
        try {
            Desktop.getDesktop().browse(new URL(reqUrl).toURI());
        } catch (URISyntaxException ex) {
            throw new IOException(ex);
        }
    }

    public String getHistory(String userId, int offset, int count, boolean rev) throws IOException {
        return invokeApi("messages.getHistory", Params.create()
                .add("user_id", userId)
                .add("offset", String.valueOf(offset))
                .add("count", String.valueOf(count))
                .add("rev", rev ? "1" : "0"));
    }

    public String getFriends() throws IOException {
        String nickname = "nickname";
        String domain = "domain";
        String sex = "sex";
        String country = "country";
        String city = "city";

        return invokeApi("friends.get", Params.create()
//                .add("count", String.valueOf(1))
                .add("fields", nickname));
//                .add("fields", domain)
//                .add("fields", sex)
//                .add("fields", city));
    }

    private String invokeApi(String method, Params params) throws IOException {
        final String parameters = (params == null) ? "" : params.build();
        String reqUrl = API_REQUEST
                .replace("{METHOD}", method)
                .replace("{TOKEN}", accessToken)
                .replace("{PARAMS}&", parameters);
        final StringBuilder result = new StringBuilder();
        final URL url = new URL(reqUrl);
        try (InputStream is = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.lines().forEach(result::append);
        }

        return result.toString();
    }

    private static class Params {

        public static Params create() {
            return new Params();
        }

        private final HashMap<String, String> params;

        private Params() {
            params = new HashMap<>();
        }

        public Params add(String key, String value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            if (params.isEmpty()) return "";
            final StringBuilder out = new StringBuilder();
            params.keySet().stream().forEach(key -> {
                out.append(key).append('=').append(params.get(key)).append('&');
            });
            return out.toString();
        }
    }

}