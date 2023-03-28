
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <h1 class="w-100 d-flex justify-content-center">Новый Клиент:</h1>
    <div class="w-100 d-flex justify-content-center my-3">
        <div class="card border-0" style="width: 25rem;">
            <div class="card-body">
                <form method="POST" action="registration">
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
                    <div class="mb-2 row">
                        <label for="phone" class="col-sm-3 col-form-label">Телефон:</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="phone" name="phone" value="${phone}">
                        </div>
                    </div>
                    <div class="mb-2 row">
                        <label for="login" class="col-sm-3 col-form-label">Логин:</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="login" name="login" value="${login}">
                        </div>
                    </div>
                    <div class="mb-2 row">
                        <label for="password" class="col-sm-3 col-form-label">Пароль:</label>
                        <div class="col-sm-9">
                          <input type="password" class="form-control" id="password" name="password" value="${password}">
                        </div>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                        <button type="submit" class="btn btn-primary me-md-2">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

