<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>jQuery Image Slider with Thumbnails, Bullets and Slideshow</title>

    <link rel="stylesheet" href="resources/assets/css/gallery.css">

    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>

<div class="galleryContainer">
    <h1>jQuery Image Slider with Thumbnails, Bullets and Slideshow</h1>
    <p>Created by HTML-TUTS.com. You can view the full tutorial <a href="http://html-tuts.com/?p=8898" rel="nofollow" target="_blank">here</a></p>

    <div class="galleryThumbnailsContainer">
        <div class="galleryThumbnails">
                <%--ImageCount - кол-во фотографий у пользователя (должен передаваться из контроллера) --%>
                <c:forEach var="t" begin="1" end="${imageCount}" >
                    <a href="javascript: changeimage(${t})" class="thumbnailsimage${t}">
                        <img src="resources/assets/images/thumbs/image${t}.jpg" width="auto" height="100" alt="" />
                    </a>
                </c:forEach>
        </div>
    </div>

    <div class="galleryPreviewContainer">
        <div class="galleryPreviewImage">
                <c:forEach var="i" begin="1" end="${imageCount}" >
                    <img class="previewImage${i}" src="resources/assets/images/image${i}.jpg" width="900" height="auto" alt="" />
                </c:forEach>
        </div>

        <div class="galleryPreviewArrows">
            <a href="#" class="previousSlideArrow">&lt;</a>
            <a href="#" class="nextSlideArrow">&gt;</a>
        </div>
    </div>

    <div class="galleryNavigationBullets">
        <c:forEach var="b" begin="1" end="${imageCount}" >
            <a href="javascript: changeimage(${b})" class="galleryBullet${b}"><span>Bullet</span></a>
        </c:forEach>
    </div>
</div>

<script type="text/javascript">
    // init variables
    var imagesTotal = ${imageCount};
    var currentImage = 1;
    var thumbsTotalWidth = 0;

    $('a.galleryBullet' + currentImage).addClass("active");
    $('a.thumbnailsimage' + currentImage).addClass("active");


    // SET WIDTH for THUMBNAILS CONTAINER
    $(window).load(function() {
        $('.galleryThumbnails a img').each(function() {
            thumbsTotalWidth += $(this).width() + 10 + 8;
        });
        $('.galleryThumbnails').width(thumbsTotalWidth);
    });

    // PREVIOUS ARROW CODE
    $('a.previousSlideArrow').click(function() {
        $('img.previewImage' + currentImage).hide();
        $('a.galleryBullet' + currentImage).removeClass("active");
        $('a.thumbnailsimage' + currentImage).removeClass("active");

        currentImage--;

        if (currentImage == 0) {
            currentImage = imagesTotal;
        }

        $('a.galleryBullet' + currentImage).addClass("active");
        $('a.thumbnailsimage' + currentImage).addClass("active");
        $('img.previewImage' + currentImage).show();

        return false;
    });
    // ===================


    // NEXT ARROW CODE
    $('a.nextSlideArrow').click(function() {
        $('img.previewImage' + currentImage).hide();
        $('a.galleryBullet' + currentImage).removeClass("active");
        $('a.thumbnailsimage' + currentImage).removeClass("active");

        currentImage++;

        if (currentImage == imagesTotal + 1) {
            currentImage = 1;
        }

        $('a.galleryBullet' + currentImage).addClass("active");
        $('a.thumbnailsimage' + currentImage).addClass("active");
        $('img.previewImage' + currentImage).show();

        return false;
    });
    // ===================


    // BULLETS CODE
    function changeimage(imageNumber) {
        $('img.previewImage' + currentImage).hide();
        currentImage = imageNumber;
        $('img.previewImage' + imageNumber).show();
        $('.galleryNavigationBullets a').removeClass("active");
        $('.galleryThumbnails a').removeClass("active");
        $('a.galleryBullet' + imageNumber).addClass("active");
        $('a.thumbnailsimage' + currentImage).addClass("active");
    }
    // ===================


    // AUTOMATIC CHANGE SLIDES
    function autoChangeSlides() {
        $('img.previewImage' + currentImage).hide();
        $('a.galleryBullet' + currentImage).removeClass("active");
        $('a.thumbnailsimage' + currentImage).removeClass("active");

        currentImage++;

        if (currentImage == imagesTotal + 1) {
            currentImage = 1;
        }

        $('a.galleryBullet' + currentImage).addClass("active");
        $('a.thumbnailsimage' + currentImage).addClass("active");
        $('img.previewImage' + currentImage).show();
    }

    var slideTimer = setInterval(function() {autoChangeSlides(); }, 3000);
</script>

</body>
</html>

