<!DOCTYPE html>
<html>
<head>
    <title>404 - page not fount</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0px;
            padding: 0px;
            font-family: 'Open Sans', sans-serif;
            font-size: 16px
        }

        body {
            background: url('/404.png') center no-repeat #fff
        }

        .content {
            width: 100%;
            text-align: center;
            position: absolute;
            bottom: 10%;
            left: 0px;
        }

        .content a {
            display: inline-block;
            text-decoration: none
        }

        .content a:hover {
            opacity: 0.7
        }

        .content a, .content a:hover {
            color: #737f83;
            font-size: 14px
        }

        @media only screen and (max-width: 46px), screen and (max-height: 70px) {
            .content {
                position: static;
            }

            .content a {
                display: block;
                width: 100%;
                height: 100%;
                position: absolute;
                top: 0px;
                left: 0px;
                font-size: 0px;
                opacity: 0;
            }

            body {
                background-size: cover
            }
        }
    </style>
</head>
<body>
<div class="content">
    <a href="/"><h2>Back to home</h2></a>
</div>
</body>
</html>