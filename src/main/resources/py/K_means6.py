#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np 
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import os
import random 
import sys
import json


# In[2]:


#这个是聚类实现过程
#clustres 簇。iterations 迭代次数。 centroids 中心点。 exmples 数据。
class KMeans:
    def __init__(self,data,num_clustres):#传入数据date和簇的数量num_clustres
        self.data=data
        self.num_clustres=num_clustres
        
    def train(self,max_iterations):#传入最大迭代次数max_iterations
        #1.先随机选择k个中心点
        centroids=KMeans.centroids_init(self.data,self.num_clustres)
        #2.开始训练
        num_examples=self.data.shape[0]
        closest_centroids_ids=np.empty((num_examples,1))
        for _ in range(max_iterations):
            #3得到当前每一个样本点到k个中心点的距离，找到最近的
            closest_centroids_ids=KMeans.centroids_find_closest(self.data,centroids)
            #4进行中心点位置更新
            centroids=KMeans.centroids_compute(self.data,closest_centroids_ids,self.num_clustres)
        return centroids,closest_centroids_ids#返回的第一个是中心点的坐标，第二个是每个数据的label值
               
    @staticmethod
    def centroids_init(data,num_clustres):#初始化中心点，传入簇的数量num_clustres
        num_examples=data.shape[0]#数据的数量
        random_ids=np.random.permutation(num_examples)#随机排列数列
        centroids=data[random_ids[:num_clustres],:]
        return centroids
    
    @staticmethod
    def centroids_find_closest(data,centroids):#计算最短距离，传入中心点数组centroids
        num_examples=data.shape[0]#数据的数量
        num_centroids=centroids.shape[0]#中心点的数量
        closest_centroids_ids=np.zeros((num_examples,1))#先初始化为0
        for exmples_index in range(num_examples):#循环每个数据
            distance =np.zeros((num_centroids,1))
            for centroids_index in range(num_centroids):#循环每个中心点
                distance_diff=data[exmples_index,:]-centroids[centroids_index,:]#计算点于点的距离
                distance[centroids_index]=np.sum(distance_diff**2)
            closest_centroids_ids[exmples_index]=np.argmin(distance)#找到数组中的最小值下标，既中心点下标
        return  closest_centroids_ids
    
    @staticmethod
    def centroids_compute(data,closest_centroids_ids,num_clustres):#更新中心点，传入每个数据对应的中心点closest_centroids_ids，簇的数量num_clustres
        num_features=data.shape[1]
        centroids=np.zeros((num_clustres,num_features))
        for centroid_id in range(num_clustres):#循环簇的数量次，找出同样数量的中心点
            closest_ids=closest_centroids_ids==centroid_id#找到下标对应的
            centroids[centroid_id]=np.mean(data[closest_ids.flatten(),:],axis=0)#计算均值
        return centroids
        
        
        
        
        
        


# In[3]:


#这个是实现数据导入，分析
class vis:
    import sys
    def __init__(self,data,num_clustres):
        self.data=data
        self.num_clustres=num_clustres
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
    #传入的在这里，path是路径
    def show():#data_path,num_clustres,x_axis,y_axis,path///#传入数据路径date_path和簇的数量num_clustres,和用户指定的两个变量
        data_path=str(sys.argv[1])#传入数据路径
        num_clustres=int(sys.argv[2])#簇的数量
        x_axis=str(sys.argv[3])#用户指定的第一个变量
        y_axis=str(sys.argv[4])#用户指定的第二个变量
        path=str(sys.argv[5])#结果文件的存储路径
        
        data=pd.read_excel(data_path)
        num_examples=data.shape[0]
        x_train=data[[x_axis,y_axis]].values.reshape(num_examples,2)#传入数据，两列，根据用户的给定的变量
        max_iteritions=50#最大迭代次数
        k_means=KMeans(x_train,num_clustres)
        centroids,closest_centroids_ids=k_means.train(max_iteritions)
        plt.figure( figsize=(12,5))
        for centroid_id,centroid in enumerate(centroids):#簇
            current_examples_index=(closest_centroids_ids==centroid_id).flatten()              
            plt.scatter(data[x_axis][current_examples_index],data[y_axis][current_examples_index])

        for centroid_id,centroid in enumerate(centroids):#中心点
            plt.scatter(centroid[0],centroid[1],c='black',marker='x')
        plt.xlabel(x_axis)
        plt.ylabel(y_axis)
        file_name=vis.random_name(10)#可定义文件名的长度
        plt.savefig(path+file_name)#保存图片，可以在这里设置存储路径
        print(path+file_name+".png")#第一个返回的是文件名，第二个返回的是文件路径


# In[4]:


def main():
    vis.show()
if __name__=="__main__":
    main()


# In[ ]:




