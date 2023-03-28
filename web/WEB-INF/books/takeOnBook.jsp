

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="w-100 d-flex justify-content-center">Выдача обуви</h1>
<div class="w-100 d-flex justify-content-center">
    <div class="card border-0" style="width: 25rem;">
      <div class="card-body">
        <h3 class="card-title w-100 my-3">Список поставщиков обуви</h3>
        <form action="createHistory" method="POST">
            <p class="card-text w-100">
                <select name="bookId" class="w-100">
                    <option selected disabled>Выберите обувь</option>
                    <c:forEach var="book" items="${listBooks}">
                        <option value="${book.id}">${book.name}</option>
                    </c:forEach>
                </select>
            </p>
            <p class="card-text w-100 d-flex justify-content-end">
                <input type="submit" value="Выдать обувь">
            </p>
        </form>
           
      </div>
    </div>
</div>
        
        
    