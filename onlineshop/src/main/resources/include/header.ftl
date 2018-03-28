
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <!-- TODO: change when we implement authorization -->
                    <h4 class="text-white"><a href="/?admin=true" class="text-white">Admin Panel</a></h4>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Categories</h4>
                    <ul class="list-unstyled">
                        <li><a href="/" class="text-white">All Products</a></li>
                                <#list categories as category>
                                    <li><a href="/?category=${category.title}" class="text-white">${category.title}</a></li>
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
            <form action="/search" method="post">
                <input type="text" name="search" value="">
            </form>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>
