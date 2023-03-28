
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1  class="w-100 d-flex justify-content-center">Новый работник:</h1>
        <div class="w-100 d-flex justify-content-center">
    <div class="card border-0" style="width: 25rem;">
        <div class="card-body">
        <form method="POST" action="createAuthor">
            <div class="mb-2 row">
                <label for="firstName" class="col-sm-3 col-form-label">Имя:</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="firstName" name="firstname" value="${firstname}">
                </div>
            </div>
            <div class="mb-2 row">
                <label for="lastName" class="col-sm-3 col-form-label">Фамилия:</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="lastName" name="lastname" value="${lastname}">
                </div>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary me-md-2">Добавить</button>
            </div>
        </form>
        </div>
    </div>
    
