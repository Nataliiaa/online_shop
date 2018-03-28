<#include "/include/layout.ftl" />

<@standardPage title="Cart | Online Shop">

<main role="main">
    <div class="container">

        <#if emptyCart>
            <h3>Your Shopping Cart is empty.</h3>
            <p>Your Shopping Cart lives to serve. Give it purpose &mdash; fill it with
                <#list categories as category>
                    <a href="/?category=${category.title}">${category.title}</a>,
                </#list>
                 and more.
                Continue shopping on the <a href="/">DanITShop.com homepage</a>.</p>
        <#else>
            <h3>Shopping Cart</h3>
            <div class="row row-heading">
                <div class="col-5">Item</div>
                <div class="col-2 text-right">Price</div>
                <div class="col-1 text-right">Qty</div>
                <div class="col-2 text-right">Subtotal</div>
                <div class="col-2 text-right">Actions</div>
            </div>

            <#list cart as entry>
                <div class="row shopping-cart">
                    <div class="col-5"><a href="/product?productId=${entry.key.id}">${entry.key.title}</a></div>
                    <div class="col-2 text-right">$${entry.key.price}</div>
                    <div class="col-1 text-right">${entry.value}</div>
                    <div class="col-2 text-right">$${entry.key.price * entry.value}</div>
                    <div class="col-2 text-right">
                        <form action="/cart/action/remove" method="post">
                            <input type="hidden" name="productId" value="${entry.key.id}">
                            <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                        </form>
                    </div>
                </div>
            </#list>

            <div class="row shopping-cart">
                    <div class="col-5">Total</div>
                    <div class="col-3 text-right"></div>
                    <div class="col-2 text-right">$${cartTotal}</div>
                    <div class="col-2 text-right">
                        <form action="/cart/action/removeall" method="post">
                            <button type="submit" class="btn btn-sm btn-danger">Empty Cart</button>
                        </form>
                    </div>
            </div>
            <div class="w-100 my-3 mx-auto">
                <button type="button" class="btn btn-success float-right" onclick="window.location.href='/order'">Make Order</button>
            </div>
        </#if>

</main>

</@standardPage>