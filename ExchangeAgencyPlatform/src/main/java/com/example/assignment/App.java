package com.example.assignment;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class App {
    public static void main(String[] args) {
        try {
            // Load the dataset
            DataSource source = new DataSource("C:\\Users\\venne\\Downloads\\ExchangeAgencyPlatform\\ExchangeAgencyPlatform\\src\\main\\webapp\\dataset\\trainingData.arff");
            Instances dataset = source.getDataSet();
            dataset.setClassIndex(0);  // Assuming 'category' is the first attribute

            // Build the J48 classifier
            J48 classifier = new J48();
            classifier.buildClassifier(dataset);

            // Evaluate the classifier using 10-fold cross-validation
            Evaluation eval = new Evaluation(dataset);
            eval.crossValidateModel(classifier, dataset, 10, new Random(1));
            System.out.println(eval.toSummaryString());

            // Classify a new instance (example)
            double[] values = new double[dataset.numAttributes()];
            values[0] = dataset.attribute(0).indexOfValue("Electronics"); // Placeholder for category, to be predicted
            values[1] = dataset.attribute(1).addStringValue("New Gadget"); // name
            values[2] = dataset.attribute(2).addStringValue("BrandX");     // brand
            values[3] = dataset.attribute(3).addStringValue("4GB");        // ram
            values[4] = dataset.attribute(4).addStringValue("ModelX");     // model
            values[5] = dataset.attribute(5).addStringValue("Red");        // colour
            values[6] = dataset.attribute(6).addStringValue("?");          // size
            values[7] = dataset.attribute(7).addStringValue("?");          // type

            Instance newInstance = new DenseInstance(1.0, values);
            newInstance.setDataset(dataset);

            // Predict the category for the new instance
            double result = classifier.classifyInstance(newInstance);
            String predictedCategory = dataset.classAttribute().value((int) result);
            System.out.println("Predicted Category: " + predictedCategory);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
