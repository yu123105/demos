<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 	<base href="<%=basePath%>">
    
    <title>师资力量</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript">
		parent.document.all("main").style.height=document.body.scrollHeight;
parent.document.all("main").style.width=document.body.scrollWidth;
		</script>
		<style type="text/css">
			.block { height:7px; margin-top:-10px;}
			#t{margin-top:5px; padding-top:10px; width:980px; margin-left:auto; margin-right:auto;}
			#t1{ float:left;
			height:560px;
			width:355px; 
			margin-right:13px;
			 }
			
			 #t2{ float:left;
			height:560px;
			width:355px;
			
			 }
			 #t3{ 
			 float:right;
			height:560px;
			width:245px;;		   
			 }
			 
			 #t div div { background-image:url(images/title.png); background-repeat:no-repeat; padding-top:7px; height:270px; margin-top:-10px; overflow:hidden; padding-left:10px; padding-right:10px; margin-bottom:20px; 
			 -moz-box-shadow: 3px 3px 4px #666666;
    -webkit-box-shadow: 3px 3px 4px #666666;
    box-shadow: 0px 0px 5px #666666;
    /* For IE 8 */
    -ms-filter: "progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666')";
    /* For IE 5.5 - 7 */
    filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666');
			 }
			 #t div div strong{ color:#ffffff; margin-left:23px;  font-size:16px; margin-top:-15px; font-family:"Microsoft YaHei UI"; font-weight:normal;}
			 
		</style>
</head>


 <body >
	
        <div class="container" >
            <div class="wrapper">
                <div id="ei-slider" class="ei-slider" style="width:980px; height:250px; -moz-box-shadow: 3px 3px 4px #666666;
    -webkit-box-shadow: 3px 3px 4px #666666;
    box-shadow: 0px 0px 14px #666666;
    /* For IE 8 */
    -ms-filter: "progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666')";
    /* For IE 5.5 - 7 */
    filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666');">
                    <ul class="ei-slider-large">
						<li>
                            <img src="images/banner1.jpg" alt="image06"/>
                            <div class="ei-title">
                               <!-- <h2>Passionate</h2>
                                <h3>Seeker</h3>-->
                            </div>
                        </li>
                        <li>
                            <img src="images/banner2.jpg" alt="image01" />
                            <div class="ei-title">
                                <!--<h2>Creative</h2>
                                <h3>Duet</h3>-->
                            </div>
                        </li>
                        <li>
                            <img src="images/banner3.jpg" alt="image02" />
                            <div class="ei-title">
                               <!-- <h2>Friendly</h2>
                                <h3>Devil</h3>-->
                            </div>
                        </li>
                        <li>
                            <img src="images/banner4.jpg" alt="image03"/>
                            <div class="ei-title">
                                <!--<h2>Tranquilent</h2>
                                <h3>Compatriot</h3>-->
                            </div>
                        </li>
                       
                    </ul><!-- ei-slider-large -->
                    <ul class="ei-slider-thumbs" style="margin-top:-13px;">
                        <li class="ei-slider-element">Current</li>
						<li><a href="#">Slide3</a><img src="images/sbanner1.jpg" alt="thumb03" /></li>
                        <li><a href="#">Slide 4</a><img src="images/sbanner2.jpg" alt="thumb04" /></li>
                        <li><a href="#">Slide 5</a><img src="images/sbanner3.jpg" alt="thumb05" /></li>
                        <li><a href="#">Slide 7</a><img src="images/sbanner4.jpg" alt="thumb07" /></li>
                    </ul><!-- ei-slider-thumbs -->
                </div><!-- ei-slider -->
            </div>
            <!-- wrapper -->
        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.eislideshow.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#ei-slider').eislideshow({
					animation			: 'center',
					autoplay			: true,
					slideshow_interval	: 3000,
					titlesFactor		: 0
                });
            });
        </script>
		<div id="t" >
			<div id="t1" >
			  <div id="t1-1">
					
				   <a href="introduce.html"><img align="right"  src="images/more.gif"/></a> <strong>课程简介</strong>								
				   <br/>
				   <br/><br/>
				   <br/><br/>
				   
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本专业培养具备管理、经济、法律及工商管理（会展管理）方面的知识和能力，熟悉会展策划、营销、管理和服务等全过程实务运作流程，具备会展组织与管理等基本能力，具有较强的外语和计算机运用能力，能在企、事业单位等相关部门从事会展营销、会展招展、会展项目开发与管理、会议组织与管理、展位设计等岗位以及教学、科研方面工作的工商管理类会展商务管理高级应用性专门人才。
				  
				   </div>
				<div id="t1-2">
				   <a href="videos.jsp"><img align="right"  src="images/more.gif"/></a> <strong>教学视频</strong>
				   <br/>
				   <br/>
				 <video width="320" height="160" controls="controls" >
  				<source src="videos/1.mp4" type="video/mp4" />
  				<object data="videos/1.mp4" width="420" height="160">
 				 </object>
</video>
				</div>
			</div>
			<div  id="t2">
				<div id="t2-1">
				   <a href="teachers.jsp"><img align="right"  src="images/more.gif"/></a> <strong>师资力量</strong>
				   <br/>
				   <br/>
				   <img src="images/teacher1.png" style="height:130px; width:110px; float:left;">
				   xxx出身于1968年...
				</div>
				<div id="t2-2">
				   <a href=""><img align="right"  src="images/more.gif"/></a> <strong>课程通知</strong>
				   <br/>
				   <br/>
				  <span style=" float:right;"> 1990.06.01</span> <li style="text-overflow:ellipsis;overflow:hidden;text-align:left; width:240px;"><a href="#" title="课程通知1"> <nobr>课程程通知课通知课程通知课程通知课程通知课程课程通程通课程通程通课程通程通知知</nobr></a></li>
				   <br/>
				   会展课程是一门专业性很高的课程。<br/>
				   <br/>
				   会展课程是一门专业性很高的课程。<br/>
				   <br/>
				   会展课程是一门专业性很高的课程。<br/>
				   <br/>
				   会展课程是一门专业性很高的课程。
				</div>
			</div>
			<div id="t3">
			<div id="t3-1" style="height:150px; ">
			 <a href="calendars.jsp"><img align="right"  src="images/more.gif"/></a> &nbsp;<strong style="margin-left:15px;">教学日历</strong>
				   <br/>
				   <br/>
				   <span style=" float:right;"> 1990.06.01</span> <li style="text-overflow:ellipsis;overflow:hidden;text-align:left; width:150px;"><a href="#" title="课程通知1"> <nobr>课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载</nobr></a></li>
			</div>
				<div id="t3-2" style="height:390px;">
				   <a href="coursewares.jsp"><img align="right"  src="images/more.gif"/></a> &nbsp;<strong style="margin-left:15px;">课件下载</strong>
				   <br/>
				   <br/>
				   <span style=" float:right;"> 1990.06.01</span> <li style="text-overflow:ellipsis;overflow:hidden;text-align:left; width:150px;"><a href="#" title="课程通知1"> <nobr>课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载课件下载</nobr></a></li>
				</div>
				
			</div>
		</div>
		<iframe id="iframeC" name="iframeC" src="" width="0" height="0" style="display:none;" ></iframe>
<script type="text/javascript"> 
function sethash(){
	hashH = Math.min(document.documentElement.scrollHeight,document.body.scrollHeight+101); 
    urlC = "agent.html"; 
    document.getElementById("iframeC").src=urlC+"#"+hashH; 
}
sethash();
</script>
    </body>
</html>

