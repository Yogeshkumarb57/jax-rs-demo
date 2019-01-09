package com.jaxrs.config;

public class SwaggerConfigUsingServlet {//extends HttpServlet {
   /* @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String host=null;
        InetAddress inetAddress = null;
        try{
           inetAddress =InetAddress.getLocalHost();
           host = inetAddress.getHostAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost(host+":7000");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }*/
}