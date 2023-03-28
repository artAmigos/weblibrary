

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <h3 class="w-100 mt-5 d-flex justify-content-center">Новая обувт</h3>
        <div class="w-100 d-flex justify-content-center p-5">
            <div class="card" style="width: 40rem;">
                <div class="card-body">
                    <p class="w-100 d-flex justify-content-center p-5"><a href="addCover">Добавить обложку для обуви</a></p>
                    <form method="POST" action="createBook">
                      <div class="mb-3 row">
                        <label for="bookName" class="col-sm-5 col-form-label">Название обуви: </label>
                        <div class="col-sm-7">
                          <input type="text" class="form-control" id="bookName" name="name" value="">
                        </div>
                      </div>
                      <div class="mb-3 row">
                        <label for="published-year" class="col-sm-5 col-form-label">Год выпуска обуви: </label>
                        <div class="col-sm-7">
                          <input type="text" class="form-control" id="published-year" name="publishedYear" value="">
                        </div>
                      </div>
                      <div class="mb-3 row">
                        <label for="quantity" class="col-sm-5 col-form-label">Количество экземпляров обуви: </label>
                        <div class="col-sm-7">
                          <input type="text" class="form-control" id="quantity" name="quantity" value="">
                        </div>
                      </div>
                      <div class="mb-3 row">
                        <label for="authors_select" class="col-sm-5 col-form-label">Список работников:</label>
                        <div class="col-sm-7">
                            <select name="authors" id="authors_select" class="form-select" multiple>
                                <c:forEach var="author" items="${listAuthors}">
                                    <option value="${author.id}">${author.firstname} ${author.lastname}</option>
                                </c:forEach>
                            </select>
                        </div>
                      </div>
                      <div class="mb-3 row">
                        <label for="covers_select" class="col-sm-5 col-form-label justify-content-md-end">Обложки:</label>
                        <div class="col-sm-7">
                            <select name="coverId" id="covers_select" class="form-select">
                                <option value="#" selected disabled>Выберите обложку</option>
                                <c:forEach var="cover" items="${listCovers}">
                                    <option value="${cover.id}">${cover.description}</option>
                                </c:forEach>
                            </select>
                        </div>
                      </div>

                      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                          <button type="submit" class="btn btn-primary me-md-2">Добавить</button>
                      </div>

                    </form>
                </div>
            </div>
        </div>
    
