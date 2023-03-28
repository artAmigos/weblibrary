

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1 class="w-100 d-flex justify-content-center">Список клиентов</h1>
        <div class="w-100 d-flex justify-content-center">
            <div class="card border-0" style="width: 25rem;">
                <div class="card-body">
                    <ol>
                        <c:forEach var="reader" items="${listReaders}">
                            <li>
                                <h4>${reader.firstname} ${reader.lastname}.</h4> Телефон: ${reader.phone}
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
        </div>
    