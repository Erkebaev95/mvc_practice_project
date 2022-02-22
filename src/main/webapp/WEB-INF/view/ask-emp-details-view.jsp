<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>

<body>
    <h2>Dear Employee, please enter your details</h2>

    <br>
    <br>

    <%-- simple way to show details --%>
    <%--<form action="showDetails" method="get">
        <input type="text" name="employeeName"
        placeholder="Write your name" />

        <input type="submit" />
    </form>--%>

    <form:form action="showDetails" modelAttribute="employee">

        Name <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>
        Surname <form:input path="surName"/>
        <form:errors path="surName"/>
        <br><br>
        Salary <form:input path="salary"/>
        <br><br>
        <%--Hard coded way drop down list --%>
        <%--Department<form:select path="department">
            <form:option value="Information Technology" label="IT"/>
            <form:option value="Human Resources" label="HR"/>
            <form:option value="Sales" label="Sales"/>
        </form:select>--%>

        <%-- drop down list with using Map --%>
        Department <form:select path="department">
            <form:options items="${employee.departments}"/>
        </form:select>
        <br><br>
        <%-- we use form with radio button --%>
        Which car do you want?
        <br>
        <%-- Hard coded way --%>
        <%--BMW <form:radiobutton path="carBrand" value="BMW"/>
        Audi <form:radiobutton path="carBrand" value="Audi"/>
        Mercedes-Benz <form:radiobutton path="carBrand" value="Mercedes-Benz"/>
        --%>

        <%-- radio button with using Map --%>
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
        <br><br>

        <%-- hard coded form check box --%>
        Foreign Language(s)
        <br>
        <%--EN <form:checkbox path="languages" value="English"/>
        DE <form:checkbox path="languages" value="Deutch"/>
        FR <form:checkbox path="languages" value="French"/>--%>

        <%-- better way form check box --%>
        <form:checkboxes path="languages" items="${employee.languageList}"/>


        <br><br>
        <input type="submit" value="OK">

    </form:form>

</body>

</html>