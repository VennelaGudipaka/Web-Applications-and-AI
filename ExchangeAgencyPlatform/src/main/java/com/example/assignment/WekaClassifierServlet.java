package com.example.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WekaClassifierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WekaClassifier classifier;

    @Override
    public void init() throws ServletException {
        super.init();
        String relativePath = getServletConfig().getInitParameter("trainingDataPath");
        if (relativePath == null || relativePath.trim().isEmpty()) {
            throw new IllegalArgumentException("Training data path cannot be null or empty.");
        }

        String absolutePath = getServletContext().getRealPath(relativePath);
        try {
            classifier = new WekaClassifier(absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Failed to initialize WekaClassifier", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] attributeValues = {
            request.getParameter("category"),
            request.getParameter("name"),
            request.getParameter("brand"),
            request.getParameter("ram"),
            request.getParameter("model"),
            request.getParameter("size"),
            request.getParameter("color"),
            request.getParameter("type"),
            request.getParameter("description"),
            request.getParameter("condition")
        };

        if (!classifier.validateInputData(attributeValues)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data.");
            return;
        }

        String classificationResult;
        String evaluationResults;

        try {
            classificationResult = classifier.classify(attributeValues);
            evaluationResults = classifier.evaluateClassifiers();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error during classification or evaluation.");
            return;
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Classification Result</h2>");
        response.getWriter().println("<p>Category: " + attributeValues[0] + "</p>");
        response.getWriter().println("<p>Name: " + attributeValues[1] + "</p>");
        response.getWriter().println("<p>Brand: " + attributeValues[2] + "</p>");
        response.getWriter().println("<p>RAM: " + attributeValues[3] + "</p>");
        response.getWriter().println("<p>Model: " + attributeValues[4] + "</p>");
        response.getWriter().println("<p>Size: " + attributeValues[5] + "</p>");
        response.getWriter().println("<p>Color: " + attributeValues[6] + "</p>");
        response.getWriter().println("<p>Type: " + attributeValues[7] + "</p>");
        response.getWriter().println("<p>Description: " + attributeValues[8] + "</p>");
        response.getWriter().println("<p>Condition: " + attributeValues[9] + "</p>");
        response.getWriter().println("<p>Classification: " + classificationResult + "</p>");
        response.getWriter().println("<h2>Evaluation Results</h2>");
        response.getWriter().println("<pre>" + evaluationResults + "</pre>");
        response.getWriter().println("</body></html>");
    }
}
