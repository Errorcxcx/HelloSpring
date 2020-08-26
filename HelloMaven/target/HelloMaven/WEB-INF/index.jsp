<%@ page language="java" pageEncoding="utf-8" import="java.util.*" %>
<%
    String path = request.getContextPath();
    %>
<html>
<head>
    <style type="text/css">
        .top{
            /* 设置宽度高度背景颜色 */
            height: auto; /*高度改为自动高度*/
            width:100%;
            margin-left: 0;
            background:rgb(189, 181, 181);
            position: fixed; /*固定在顶部*/
            top: 0;/*离顶部的距离为0*/
            margin-bottom: 5px;
        }
        .top ul{
            /* 清除ul标签的默认样式 */
            width: auto;/*宽度也改为自动*/
            list-style-type: none;
            white-space:nowrap;
            overflow: hidden;
            margin-left: 5%;
            /* margin-top: 0;          */
            padding: 0;

        }
        .top li {
            float:left; /* 使li内容横向浮动，即横向排列  */
            margin-right:2%;  /* 两个li之间的距离*/
            position: relative;
            overflow: hidden;
        }

        .top li a{
            /* 设置链接内容显示的格式*/
            display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
            color:white;
            text-align: center;
            padding: 3px;
            overflow: hidden;
            text-decoration: none; /* 去除下划线 */

        }
        .top li a:hover{
            /* 鼠标选中时背景变为黑色 */
            background-color: #111;
        }
        .top ul li ul{
            /* 设置二级菜单 */
            margin-left: -0.2px;
            background:rgb(189, 181, 181);
            position: relative;
            display: none; /* 默认隐藏二级菜单的内容 */

        }
        .top ul li ul li{
            /* 二级菜单li内容的显示 */

            float:none;
            text-align: center;
        }
        .top ul li:hover ul{
            /* 鼠标选中二级菜单内容时 */
            display: block;
        }
        body{
            background:#eff3f5;
        }

    </style>
<body>
<div class="top">
    <div style="text-align: center;">
        <ul>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#"><b>一级菜单</b></a></li>
            <li><a href="#">一级菜单</a></li>
            <li>
                <a href="#">一级菜单</a>
                <ul>
                    <li><a href="#">二级菜单</a></li>
                    <li><a href="#">二级菜单</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
</body>
</head>
<body>

</body>
</html>
