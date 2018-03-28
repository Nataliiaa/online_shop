<#include "/include/layout.ftl" />

<@standardPage title="Home | Online Shop">

       <main role="main">

            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">${currentCategory}</h1>
                    <#if isAdmin>
                    <h2>Add Product</h2>
                    <form action="/product/action/add" method="post">
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
                            <option value="${category.title}">${category.title}</option>
                        </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="productDescription">Comment</label>
                            <textarea name="productDescription" class="form-control" rows="3" id="productDescription"></textarea>
                        </div>
                        <button type="submit" class="btn btn-sm btn-outline-secondary">Add Product</button>
                    </form>
                    </#if>
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
                                            <form action="/cart/action/add" method="post">
                                                <input type="hidden" name="productId" value="${product.id}">
                                                <button type="submit" class="btn btn-sm btn-outline-secondary">Add To Cart</button>
                                            </form>
                                            <#if isAdmin>
                                            <form action="/product/action/remove" method="post">
                                                <input type="hidden" name="productId" value="${product.id}">
                                                <button type="submit" class="btn btn-sm btn-warning">Remove</button>
                                            </form>
                                            </#if>
                                        </div>
                                        <small class="text-muted">$${product.price}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </#list>
                    </div>

                    <#if noProducts>
                        <h4>There are no products in this category.</h4>
                    </#if>
                </div>
            </div>

        </main>

</@standardPage>