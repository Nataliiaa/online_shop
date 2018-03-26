<#include "/include/layout.ftl" />

<@standardPage title="${product.title} | Online Shop">

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

</@standardPage>