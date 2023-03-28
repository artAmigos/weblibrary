
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1 class="w-100 d-flex justify-content-center">Список Работников</h1>
        <div class="w-100 d-flex justify-content-center">
            <div class="card border-0" style="width: 25rem;">
                <div class="card-body">
                <ol>
                    <c:forEach var="author" items="${listAuthors}">
                        <li>
                            <h5>${author.firstname} ${author.lastname}.</h5>
                            <ol>
                                <c:forEach var="book" items="${author.books}">
                                    <li> <a href="book?id=${book.id}">${book.name}. ${book.publishedYear}</a></li>
                                </c:forEach>
                            </ol>
                        </li>
                    </c:forEach>
                </ol>
                </div>
            </div>
        </div>
   