<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div id="main">
    <aside class="leftAside">
        <h2>For registration on this site</h2>
        <p>You should fill all fields bellow
    </aside>
    <section>
        <article>
            <h1>Registration</h1>
            <div class="text-article">
                <form method="GET" action="registration">
                    <p>
                        <label for="email">E-Mail</label>
                        <input type="email" name="email" id="email"/>
                    </p>
                    <p>
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password"/>

                        <label for="password2">Repeat password</label>
                        <input type="password" name="password2" id="password2"/>
                    </p>
                    <p>
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name"/>
                    </p>
                    <p>
                        <label for="secondName">Second name</label>
                        <input type="text" name="login" id="secondName"/>
                    </p>
                    <p>
                        <label for="birthdayDate">Birthday date</label>
                        <input type="text" name="name" id="birthdayDate"/>
                    </p>
                    <p>
                        <label for="adress">Adress</label>
                        <input type="text" name="login" id="adress"/>
                    </p>
                    <p>
                    <p>
                        <label for="passport">Passport</label>
                        <input type="text" name="login" id="passport"/>
                    </p>
                    <button type="submit">SignUp</button>
                    </p>
                </form>
            </div>
        </article>
    </section>
</div>