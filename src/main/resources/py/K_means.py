#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np 


# 可找出中心点的位置和每个数据相对应的簇

# In[2]:


#clustres 簇。iterations 迭代次数。 centroids 中心点。exmples 数据。
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
