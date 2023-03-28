
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="w-100 mt-5 d-flex justify-content-center">Список Товаров</h3>

<div class="w-100 d-flex justify-content-center p-5">
    <c:forEach var="book" items="${listBooks}">
        <div class="card " style="width: 18rem">

            <a href="book?id=${book.id}">
                <img src="insertFile/${book.cover.url}" class="card-img-top" alt="...">
            </a>
        </div>
    </c:forEach>
</div>
        
    