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
            <h1 class="jumbotron-heading">Admin</h1>
            <h2>Add Product</h2>
            <form action="/admin/action/add" method="post">
                <div class="form-group">
                    <label for="productTitle">Product Title</label>
                    <input type="text" name="productTitle" class="form-control" id="productTitle">
                </div>
                <div class="form-group">
                    <label for="productImageUrl">Product Image URL</label>
                    <input type="text" name="productImageUrl" class="form-control" id="productImageUrl" placeholder="http://...">
                </div>
                <div class="form-group">
                    <label for="productPrice">Product Price</label>
                    <input type="number" name="productPrice" class="form-control" id="productPrice" value="0">
                </div>
                <div class="form-group">
                    <label for="productCategory">Product Category</label><br>
                    <select name="productCategory">
                        <#list categories as category>
                            <option value="${category}">${category.title}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label for="productDescription">Comment</label>
                    <textarea name="productDescription" class="form-control" rows="3" id="productDescription"></textarea>
                </div>
                <button type="submit" class="btn btn-sm btn-outline-secondary">Add Product</button>
            </form>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row">
                        <#list products as product>
                            <div class="col-md-4">
                                <div class="card mb-4 box-shadow">
                                    <img class="card-img-top clickable" src="${product.imageUrl}" alt="${product.title}" onclick="window.location.href='/product?productId=${product.id}'">
                                    <div class="card-body">
                                        <p class="card-text">${product.title}</p>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/product?productId=${product.id}'">View</button>
                                                <form action="/admin/action/remove" method="post">
                                                    <input type="hidden" name="productId" value="${product.id}">
                                                    <button type="submit" class="btn btn-sm btn-warning">Remove</button>
                                                </form>

                                            </div>
                                            <small class="text-muted">$${product.price}</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
            </div>
        </div>
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