<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to RabbitMQDemo</title>
</head>

<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <g:each in="${fordModelList}" var="${fordModel}">
            <span>
                <div class="centered">
                    <g:link controller="fordModel" id="${fordModel.id}" action="show">
                        <img src="${fordModel.image}"/>
                    </g:link></div>

                <div class="centered">${fordModel.name}</div>
            </span>
        </g:each>
    </section>
</div>
</body>
</html>
