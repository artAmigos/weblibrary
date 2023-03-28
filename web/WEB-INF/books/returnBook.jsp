

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="w-100 d-flex justify-content-center">Возврат обуви (брак)</h1>
<div class="w-100 d-flex justify-content-center">
    <div class="card border-0" style="width: 25rem;">
        <div class="card-body">
            <h3 class="card-title w-100 my-3">Список покупок клиентов</h3>
            <form action="updateHistory" method="POST">
                <p class="card-text w-100">
                    <select name="historyId">
                        <c:forEach var="history" items="${listHistories}">
                            <option value="${history.id}">${history.book.name}. 
                                <c:forEach var="author" items="${history.book.authors}">
                                    ${author.firstname} ${author.lastname}. 
                                </c:forEach>
                                Купил и ходит: ${history.reader.firstname} ${history.reader.lastname}
                            </option>
                        </c:forEach>
                    </select>
                </p>
                <p class="card-text w-100 d-flex justify-content-end">
                    <input type="submit" value="Вернуть товар">
                </p>

            </form>
        </div>
    </div>
</div>
    
