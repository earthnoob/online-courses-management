<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
           <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
        <style>
            a{
                color:grey;
                text-decoration: none;
                font-weight:bold;
             }
             a.link1{
                color:#1ab2ff;
                text-decoration: none;
                font-weight:bold;
             }
             a.link2{
                color:#1ab2ff;
                text-decoration: none;
                font-weight:bold;
             }
             a.link3{
                color:#1ab2ff;
                text-decoration: none;
                font-weight:bold;
             }
        </style>
        <title>Home | All Courses you can find</title>
        </head>
        <body>
            
            <ul class="menu">
                <li class="one"><a href="#home">HOME</a></li>
                <li class="one"><a href="#courses">COURSES</a></li>
                <li class="two"><a href="#help">HELP</a></li>
                <li class="two"><a href="#login">LOG IN</a></li>
                <li class="two"><a href="#signup">SIGN UP</a></li>
            </ul>
            <br>
            <br>
            <br>
            <div class="image"></div> 
              
            <div class="contentpagetop">
                <h1>Find a course you need</h1>
                <div class="line-gradient"></div>
                <br>
                <h2>Together we built a future education and development</h2>
                <div id="searchControlBanner" class="input-group m-lr30">
                <input type="text" id="searchUI" class="form-control" placeholder="Tìm kiếm khóa học...">
                <span class="input-group-btn">
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target=".bs-Search-modal-lg">
                        <span class="fa fa-search" aria-hidden="true">
                        </span>
                    </button>
                </span>
            </div>
            <div id="showSearch">
                <div class="fm-result-search">
                <ul>
                    
                </ul>
            </div>
        </div>

        <div id="widthdisplay">
            <a href="#learn">
                <input class="btn btn-primary" type="button" value="Bắt đầu học">
            </a>
            <a href="#about">
                <input class="btn btn-warning" type="button" value="Giới thiệu">
            </a>
        </div>
        </div>                 
    </body>
    </html> 