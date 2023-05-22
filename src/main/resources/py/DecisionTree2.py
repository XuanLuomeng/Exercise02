from sklearn import tree
import numpy as np
import pandas as pd
import os
import sys
from io import StringIO
import pydotplus
x_axis='sepal_length'
y_axis='sepal_width'
data=pd.read_excel(sys.argv[0])
num = sys.argv[1]
dataSet = data[[x_axis,y_axis,'petal_length']].values.reshape(num,3)
target = data[['class']].values
X = dataSet[:100,:]
y = target[:100,:]
tree_model = tree.DecisionTreeClassifier(criterion='gini', 
                                         max_depth=4,
                                         min_samples_leaf=1
                                         )
tree_model.fit(X, y)
dot_data = StringIO()
feature_names = ['House', 'Marriage', 'Annual salary']
target_names = ['SETOSA', 'VERSICOLOR']
tree.export_graphviz(tree_model,
                     out_file=dot_data,
                     feature_names=feature_names,
                     class_names=target_names,
                     max_depth=4,                
                     filled=True, 
                     rounded=True,
                    )
graph = pydotplus.graph_from_dot_data(dot_data.getvalue())
print("E:/学习文档/default.pdf")
graph.write_pdf("E:/学习文档/default.pdf")
