<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello World</title>
        <style>.error { color: red; } .success { color:${param.color}; }</style>
    </head>
    <body>
        <form action="HelloServlet2" method="post">
            <h1>Hello</h1>
            <p>
                <label for="name">What's your name?</label>
                <input id="name" name="name" value="${param.name}">
                <span class="error">${messages.name}</span>
            </p>
            <p>
                <label for="age">What's your age?</label>
                <input id="age" name="age" value="${param.age}">
                <span class="error">${messages.age}</span>
            </p>
            
            <p>
                <label for="color">What's your favorite color?</label>
                <input id="color" name="color" value="${param.color}">
                <span class="error">${messages.color}</span>
            </p>
            
            <p>
                <input type="submit">
                <span class="success">${messages.success}</span>
            </p>
        </form>
    </body>
</html>