<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Airline Ticket</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<div class="container">
    <div class="login">
        <p>User Login</p>
        <form action="/user">
            <label for="user-username">Username</label>
            <input id="user-username" type="text" /><br />
            <label for="user-password">Password</label>
            <input id="user-password" type="text" /><br />
            <button class="button" type="submit">Login</button>
        </form>
    </div>
    <div class="login">
        <p>Airline Login</p>
        <form action="/airline">
            <label for="airline-username">Username</label>
            <input id="airline-username" type="text" /><br />
            <label for="airline-password">Password</label>
            <input id="airline-password" type="text" /><br />
            <button class="button" type="submit">Login</button>
        </form>
    </div>
</div>
</body>

<script src="main.js"></script>
</html>
