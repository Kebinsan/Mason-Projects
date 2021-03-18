<nav id = "navigation" class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="index.php" ><img src="img/logo3.png" width="120" height="110">

    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="home.php">My Profile</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="https://asana.com/?utm_expid=.fVAHSgvXTTqlbeZhKBu2uw.0&utm_referrer=#login">Tasks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="inv.php">Inventory</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">

            <li>
                <form action="logout_action.php" method="POST">
                    <button class="btn btn-dark my-2 my-sm-0" type="submit" name = "logout">Logout</button>
                </form>
            </li>
        </ul>
    </div>

    
</nav>