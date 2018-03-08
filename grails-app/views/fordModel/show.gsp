<html>
<head>
    <title>${fordModelInstance?.name}</title>
    <meta name="layout" content="main" />
</head>
<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <g:if test="${fordModelInstance}">
            <div class="centered">
                <h1><a href="${fordModelInstance.href}">${fordModelInstance.name}</a></h1>
                <p>${fordModelInstance.description} (Views ${fordModelInstance?.views + 1})</p>
                <img src="${fordModelInstance.image}"/>
                <img src="${barcode}"/>
            </div>

        </g:if>
    </section>
</div>
</body>
</html>