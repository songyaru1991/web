function getContextPath() {
    var localObj = window.location;
    var protocol = location.protocol ;
    var host = localObj.host;
    var contextPath = localObj.pathname.split("/")[1];
    return protocol +"//"+host;
}