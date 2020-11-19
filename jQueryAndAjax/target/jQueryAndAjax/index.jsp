<%--
  Created by IntelliJ IDEA.
  User: 马天宇
  Date: 2020/11/18
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>级联查询</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">

        $(function () {

            $.ajax({
                url:"province",
                type:"get",
                dataType:"json",
                async:true,
                success:function (resp) {
                    $.each(resp, function (index, element) {
                        $("#province").append("<option value='" + element.id + "'>" + element.name + "</option>");
                    });

                    // 要把getCities()放在这里，因为如果放在外面会先执行这个函数，这时候province下拉列表框还没有加载好，所以获取不到，放在这里保证加载完成后在getCities()
                    getCities();
                }
            });
            // getCities();//异步？
            $("#province").change(getCities);
        });

        function getCities() {
            // alert("hello");
            $("#city").empty();
            var $provided = $("#province>option:selected");
            $.post("city", {provided:$provided.val()}, function (resp) {
                $.each(resp, function (index, element) {
                    $("#city").append("<option value='" + element.id + "'>" + element.name + "</option>")
                });
            }, "json");
        }

    </script>
</head>
<body>
    <div>
        <select id="province">
<%--            <option value="0">请选择...</option>--%>
        </select>
        <select id="city">
<%--            <option value="0">请选择...</option>--%>
        </select>
    </div>


</body>
</html>
