#!/usr/bin/env python
# coding: utf-8

# In[1]:


from sklearn import tree
import numpy as np
import pandas as pd
import os
from io import StringIO
import pydotplus
import json
import sys
import random 


# In[5]:


class Decisiontree:
    def random_name(length):#随机名的方法，传入生成的名字长度
        digital=['1','2','3','4','5','6','7','8','9','0']
        letter=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
        i=0
        file_name=str()
        for i in range(length):
            From=random.randint(1,2)
            if From == 1:
                file_name=file_name+random.choice(digital)
            if From == 2:
                file_name=file_name+random.choice(letter)
        return file_name
    def dt():
        #第一个是数据的路径，第二、三、四是要传的三个变量，第五个是标签那一列,第六七八个是标签属性，第九个是储存路径
        data_path=str(sys.argv[1])
        x_axis=str(sys.argv[2])
        y_axis=str(sys.argv[3])
        z_axis=str(sys.argv[4])
        w_axis=str(sys.argv[5])
        x_target=str(sys.argv[6])
        y_target=str(sys.argv[7])
        z_target=str(sys.argv[8])
        path = str(sys.argv[9])
        
        data=pd.read_excel(data_path)#这个是要传进去的execl表格
        dataSet = data[[x_axis,y_axis, z_axis]].values#这个是要进行运算的列表属性
        target = data[[ w_axis ]].values#这个是属性标签
        X = dataSet[:,:]#这个是预测是数据
        y = target[:,:]#这个是标签属性
        tree_model = tree.DecisionTreeClassifier(criterion='gini', 
                                                 max_depth=4,
                                                 min_samples_leaf=1


                                                 )#这个是决策树模型的参数，限制方法
        tree_model.fit(X, y)
        dot_data = StringIO()
        feature_names = [x_axis, y_axis,z_axis]
        target_names = [x_target, y_target,z_target]
        tree.export_graphviz(tree_model,
                             out_file=dot_data,
                             feature_names=feature_names,
                             class_names=target_names,
                             max_depth=4,                
                             filled=True, 
                             rounded=True,

                            )#用于限制决策树，预剪枝
        graph = pydotplus.graph_from_dot_data(dot_data.getvalue())
        file_name=Decisiontree.random_name(10)#可定义文件名的长度
        graph.write_pdf(path+file_name+".pdf")#传出图片的名字
        print(file_name,path+file_name+".pdf")#第一个是图片的名字，第二个是图片的路径


# In[6]:


def main():
    Decisiontree.dt()
if __name__=="__main__":
    main()
    
        


# In[ ]:




