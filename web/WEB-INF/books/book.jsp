

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <div class="w-100 d-flex justify-content-center p-5">
           <div class="card" style="width: 18rem;">
            <img src="insertFile/${book.cover.url}" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">${book.name}</h5>
              <p class="card-text">Аннотация</p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">
                  Авторы:
                  <c:forEach var="author" items="${book.authors}">
                      ${author.firstname} ${author.lastname}. 
                  </c:forEach>
              </li>
              <li class="list-group-item">Дата публикации: ${book.publishedYear}</li>
              <li class="list-group-item">Количество экземпляров: ${book.count}</li>
              <li class="list-group-item">Цена: </li>
            </ul>
            <div class="card-body">
              <a href="#" class="card-link">Читать отзывы.</a>
              <a href="#" class="card-link">Купить</a>
            </div>
           </div>
        </div>
       
    
