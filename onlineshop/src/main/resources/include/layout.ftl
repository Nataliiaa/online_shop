<#macro standardPage title=""><!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/album/album.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/4.0/examples/grid/grid.css" rel="stylesheet">
    <link href="/assets/css/corrections.css" rel="stylesheet">
</head>
<body>
    <#include "/include/header.ftl">

    <#nested/>

    <#include "/include/footer.ftl">
</body>
</html>
</#macro>