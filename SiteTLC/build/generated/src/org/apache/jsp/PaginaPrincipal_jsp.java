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
String title="Timeline Chronicles";
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
      out.write("    <link href=\"../SiteTLC/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("      body {\n");
      out.write("        padding-top: 60px;\n");
      out.write("        padding-bottom: 40px;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <link href=\"../SiteTLC/css/bootstrap-responsive.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    <link href=\"../SiteTLC/css/TLCcss.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    \n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("         <div class=\"navbar navbar-fixed-top\">\n");
      out.write("              <div class=\"navbar-inner\">\n");
      out.write("                   <div class=\"container\">\n");
      out.write("                       <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <a class=\"brand\" href=\"/SiteTLC/PaginaPrincipal.jsp\">Timeline Chronicles</a>\n");
      out.write("                   <div class=\"nav-collapse collapse\">\n");
      out.write("                          <ul class=\"nav\">\n");
      out.write("                      <li class=\"active\">\n");
      out.write("                          <a href=\"/SiteTLC/PaginaPrincipal.jsp\">Home</a>\n");
      out.write("                      </li>\n");
      out.write("                      <li class=\"dropdown\">\n");
      out.write("                          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                              Jogos\n");
      out.write("                          <b class=\"caret\"></b>\n");
      out.write("                          </a>\n");
      out.write("                          <ul class=\"dropdown-menu\">\n");
      out.write("                              <li>\n");
      out.write("                                  <a href=\"#\">TLC TD</a>\n");
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
      out.write("                          <a href=\"http://timelinechronicles.forumeiros.com/\" alt=\"Forum TLC\" >Forum</a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                          <a href=\"#\">About</a>\n");
      out.write("                      </li>\n");
      out.write("                      <li>\n");
      out.write("                          <a href=\"#\">Login</a>\n");
      out.write("                      </li>    \n");
      out.write("                  </ul>\n");
      out.write("                  <form class=\"navbar-search pull-right\">\n");
      out.write("                      <input type=\"text\" class=\"search-query\" placeholder=\"Procurar\">\n");
      out.write("                  </form>\n");
      out.write("                   </div>\n");
      out.write("                   </div>\n");
      out.write("                   </div>    \n");
      out.write("          </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"hero-unit\">\n");
      out.write("    <center><img src=\"img/heroimg.png\" alt=\"tlc\" class=\"img-rounded\"></center>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <center><h1>Timeline Chronicles</h1></center>\n");
      out.write("    <div class=\"row-fluid\">\n");
      out.write("        <div class=\"span6\">\n");
      out.write("            <center>\n");
      out.write("                <h4>Fique por dentro das novidades do TLC.</h4>\n");
      out.write("            </center>    \n");
      out.write("            <p>Patch 12.1.6 notes:</p> \n");
      out.write("            <p>- Correção das fases 75 e 93;</p>\n");
      out.write("            <p>- Adicionado 3 Arquivamentos by Lennon;</p>\n");
      out.write("            <p>- Adicionado mais 3 fanarts by Arthur.</p>\n");
      out.write("            <a href=\"#\" class=\"btn btn-large btn-info\">Todas Atualizações</a>         \n");
      out.write("        </div>\n");
      out.write("        <div class=\"span6\">\n");
      out.write("            <center>\n");
      out.write("                <h4>Eventos na cidade do Acre!</h4>\n");
      out.write("            </center>\n");
      out.write("            <p>Evento TLC no fim do Mundo, dia 30/02!</p>\n");
      out.write("            <a href=\"#\" class=\"btn btn-large btn-info\">Saiba Mais</a> \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("     <footer class=\"footer\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <p class=\"pull-right\"><a href=\"#\">Back to top</a></p>\n");
      out.write("        <p>Designed and built with all the love in the world <a href=\"http://twitter.com/twitter\" target=\"_blank\">@twitter</a> by <a href=\"http://twitter.com/mdo\" target=\"_blank\">@mdo</a> and <a href=\"http://twitter.com/fat\" target=\"_blank\">@fat</a>.</p>\n");
      out.write("        <p>Code licensed under the <a href=\"http://www.apache.org/licenses/LICENSE-2.0\" target=\"_blank\">Apache License v2.0</a>. Documentation licensed under <a href=\"http://creativecommons.org/licenses/by/3.0/\">CC BY 3.0</a>.</p>\n");
      out.write("        <p>Icons from <a href=\"http://glyphicons.com\">Glyphicons Free</a>, licensed under <a href=\"http://creativecommons.org/licenses/by/3.0/\">CC BY 3.0</a>.</p>\n");
      out.write("        <ul class=\"footer-links\">\n");
      out.write("          <li><a href=\"http://blog.getbootstrap.com\">Read the blog</a></li>\n");
      out.write("          <li><a href=\"https://github.com/twitter/bootstrap/issues?state=open\">Submit issues</a></li>\n");
      out.write("          <li><a href=\"https://github.com/twitter/bootstrap/wiki\">Roadmap and changelog</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script src=\"../SiteTLC/js/jquery.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-transition.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-alert.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-modal.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-dropdown.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-scrollspy.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-tab.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-tooltip.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-popover.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-button.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-collapse.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-carousel.js\"></script>\n");
      out.write("    <script src=\"../SiteTLC/js/bootstrap-typeahead.js\"></script>\n");
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
