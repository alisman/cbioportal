<%@ tag import="org.mskcc.cbio.portal.util.GlobalProperties" %>
<%@ tag import="org.mskcc.cbio.portal.servlet.CheckDarwinAccessServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8" %>

<%@attribute name="title" %>
<%@attribute name="defaultRightColumn" %>
<%@attribute name="fixedWidth" %>

    <%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<html class="cbioportal-frontend">
<head>
    
<title>${title}</title>

<link rel="stylesheet" href="css/header.css?<%=GlobalProperties.getAppVersion()%>" />
    
<script type="text/javascript">

window.enableDarwin = <%=CheckDarwinAccessServlet.CheckDarwinAccess.existsDarwinProperties()%>;

window.appVersion = '<%=GlobalProperties.getAppVersion()%>';

// Set API root variable for cbioportal-frontend repo
<%
String url = request.getRequestURL().toString();
String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath();
baseURL = baseURL.replace("https://", "").replace("http://", "");

String fixedClass = "";

if (fixedWidth == "true") {
    fixedClass = "fixedWidth";
} 
fixedClass = "aaron";

%>
__API_ROOT__ = '<%=baseURL%>';
    

</script>

<script src="js/src/load-frontend.js?<%=GlobalProperties.getAppVersion()%>"></script>
    
<jsp:invoke fragment="head_area"/>
    
</head>


    <c:if test="${fixedWidth == true}">
        <body class="fixedWidth">
    </c:if>
    <c:if test="${fixedWidth == false}">
        <body>
    </c:if>

    <div class="pageTopContainer">
    <div class="contentWidth">
        <jsp:include page="/WEB-INF/jsp/global/header_bar.jsp" />
    </div>
    </div>
    
    <div class="contentWrapper">
            <div class="contentWidth">
            <div id="mainColumn"><jsp:invoke fragment="body_area"/></div>
            
            <c:if test="${defaultRightColumn == true}">
                <div id="rightColumn"></div>
            </c:if>
           
            </div>
    </div>
    
    </div>
    
    <jsp:include page="/WEB-INF/jsp/global/footer.jsp" />
    
    </body>
</html>