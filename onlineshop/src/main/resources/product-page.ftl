<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Online Shop</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/album/album.css" rel="stylesheet">
    <link href="/assets/css/corrections.css" rel="stylesheet">
</head>
<body>

<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white"><a href="/admin" class="text-white">Admin Panel</a></h4>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Categories</h4>
                    <ul class="list-unstyled">
                        <li><a href="/" class="text-white">All Products</a></li>
                                <#list categories as category>
                                    <li><a href="/category?category=${category}" class="text-white">${category.title}</a></li>
                                </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
            <a href="/" class="navbar-brand d-flex align-items-center">
                <strong>DanITShop.com</strong>
            </a>
            &middot;
            <a href="/cart" class="navbar-brand d-flex align-items-center">
                <strong>Cart: ${cartSize} items</strong>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>

<main role="main">
    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">${product.title}</h1>
        </div>
    </section>
    <div class="container">
        <img src="${product.imageUrl}" alt="${product.title}">
        <p>${product.description}</p>
        <p>$${product.price}</p>
        <p>
            <form action="/cart/action/add" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit" class="btn btn-primary">Add To Cart</button>
            </form>
        </p>
        <h3>Comments</h3>
        <#list product.comments as comment>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${comment.rating}<span class="text-warning">&#9733;</span></h5>
                    <p class="card-text">${comment.text}</p>
                    <p class="card-title">Author: ${comment.author}</p>
                </div>
            </div>
        </#list>
        <form action="/comment/action/add" method="post">
            <input type="hidden" name="productId" value="${product.id}">
            <div class="form-group">
                <label for="commentAuthor">Your name</label>
                <input type="text" name="commentAuthor" class="form-control" id="commentAuthor">
            </div>
            <div class="form-group">
                <label for="commentRating">Product Rating</label><br>
                <select name="commentRating">
                    <option value="5" selected="selected">5</option>
                    <option value="4">4</option>
                    <option value="3">3</option>
                    <option value="2">2</option>
                    <option value="1">1</option>
                </select>
            </div>
            <div class="form-group">
                <label for="commentText">Comment</label>
                <textarea name="commentText" class="form-control" rows="3" id="commentText"></textarea>
            </div>
            <button type="submit" class="btn btn-sm btn-outline-secondary">Add Comment</button>
        </form>
    </div>
</main>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://getbootstrap.com/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="https://getbootstrap.com/assets/js/vendor/holder.min.js"></script>
</body>
</html>