package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PaginaPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Cabecalho.jsp");
    _jspx_dependants.add("/Rodape.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
String title="Página Principal";
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en-US\">\n");
      out.write("  <head>\n");
      out.write("      <title>");
      out.print(title );
      out.write("</title>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    <link href=\"../COWBOYSFROMHELLLLLLL/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("      body {\n");
      out.write("        padding-top: 60px;\n");
      out.write("        padding-bottom: 40px;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <link href=\"../COWBOYSFROMHELLLLLLL/css/bootstrap-responsive.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    \n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("         <div class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("              <div class=\"navbar-inner\">\n");
      out.write("                   <div class=\"container\">\n");
      out.write("                       <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("                  <a class=\"brand\" href=\"#\">Le Locadora!</a>\n");
      out.write("                   <div class=\"nav-collapse collapse\">\n");
      out.write("                          <ul class=\"nav nav-pills\">\n");
      out.write("                      <li class=\"active\">\n");
      out.write("                          <a href=\"#\">Home</a>\n");
      out.write("                      </li>\n");
      out.write("                      <li class=\"dropdown\">\n");
      out.write("                          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                              Locadora\n");
      out.write("                          <b class=\"caret\"></b>\n");
      out.write("                          </a>\n");
      out.write("                          <ul class=\"dropdown-menu\">\n");
      out.write("                              <li>\n");
      out.write("                                  <a href=\"#\">Opcao 1</a>\n");
      out.write("                              </li>\n");
      out.write("                              <li>\n");
      out.write("                                  <a href=\"#\">Opcao 2</a>\n");
      out.write("                              </li>\n");
      out.write("                              <li>\n");
      out.write("                                  <a href=\"#\">Opcao 3</a>\n");
      out.write("                              </li>\n");
      out.write("                          </ul>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                          <a href=\"#\">Contato</a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                          <a href=\"#\">Sobre</a>\n");
      out.write("                      </li>\n");
      out.write("                  </ul>\n");
      out.write("                  <form class=\"navbar-search pull-right\">\n");
      out.write("                      <input type=\"text\" class=\"search-query\" placeholder=\"Procurar\">\n");
      out.write("                  </form>\n");
      out.write("                   </div>\n");
      out.write("                   </div>\n");
      out.write("                   </div>    \n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("      <script src=\"../COWBOYSFROMHELLLLLLL/js/jquery.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-transition.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-alert.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-modal.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-dropdown.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-scrollspy.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-tab.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-tooltip.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-popover.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-button.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-collapse.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-carousel.js\"></script>\n");
      out.write("    <script src=\"../COWBOYSFROMHELLLLLLL/js/bootstrap-typeahead.js\"></script>\n");
      out.write("   </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
