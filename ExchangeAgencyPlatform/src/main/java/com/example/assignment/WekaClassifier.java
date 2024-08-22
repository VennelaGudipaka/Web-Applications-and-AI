package com.example.assignment;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToNominal;

public class WekaClassifier {
    private Classifier classifier;
    private Instances trainingData;

    // Constructor
    public WekaClassifier(String trainingDataPath) throws Exception {
        loadTrainingData(trainingDataPath);
        validateClassAttribute();
        buildClassifiers();
        evaluateClassifiers();
    }

    // Method to load training data
    private void loadTrainingData(String trainingDataPath) throws Exception {
        DataSource source = new DataSource(trainingDataPath);
        trainingData = source.getDataSet();
        if (trainingData.classIndex() == -1) {
            trainingData.setClassIndex(trainingData.numAttributes() - 1);
        }

        // Convert string attributes to nominal if needed
        StringToNominal filter = new StringToNominal();
        filter.setOptions(new String[]{"-R", "first-last"});
        filter.setInputFormat(trainingData);
        trainingData = Filter.useFilter(trainingData, filter);
    }

    // Method to validate class attribute
    private void validateClassAttribute() throws Exception {
        Attribute classAttribute = trainingData.classAttribute();
        if (classAttribute.numValues() <= 1 || classAttribute.toString().equals("?")) {
            throw new Exception("Class attribute must have more than one unique value. Found: " + classAttribute.toString());
        }
    }
    

    // Method to build classifiers
    private void buildClassifiers() throws Exception {
        classifier = new J48();
        classifier.buildClassifier(trainingData);
    }

    // Method to evaluate classifiers
    public String evaluateClassifiers() throws Exception {
        Evaluation eval = new Evaluation(trainingData);
        eval.evaluateModel(classifier, trainingData);
        return eval.toSummaryString();
    }

    // Method to classify an instance
    public String classify(String[] attributeValues) throws Exception {
        Instance newInstance = new DenseInstance(trainingData.numAttributes());
        newInstance.setDataset(trainingData);

        for (int i = 0; i < attributeValues.length; i++) {
            newInstance.setValue(i, attributeValues[i]);
        }

        double predictedClass = classifier.classifyInstance(newInstance);
        return trainingData.classAttribute().value((int) predictedClass);
    }

    // Method to validate input data
    public boolean validateInputData(String[] attributeValues) {
        // Check that the number of attributes matches the number of expected attributes
        if (attributeValues.length != trainingData.numAttributes() - 1) {
            return false;
        }

        // Additional validation checks can be added here (e.g., checking for non-null values)
        for (String value : attributeValues) {
            if (value == null || value.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
