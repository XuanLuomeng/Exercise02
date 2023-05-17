from matplotlib.font_manager import FontProperties
import matplotlib.pyplot as plt
from math import log
import operator
plt.figure()
def createDataSet():
    dataSet = [[0, 0, 0, 0, 'no'],
            [0, 0, 0, 1, 'no'],
            [0, 1, 0, 1, 'yes'],
            [0, 1, 1, 0, 'yes'],
            [0, 0, 0, 0, 'no'],
            [1, 0, 0, 0, 'no'],
            [1, 0, 0, 1, 'no'],
            [1, 1, 1, 1, 'yes'],
            [1, 0, 1, 2, 'yes'],
            [1, 0, 1, 2, 'yes'],
            [2, 0, 1, 2, 'yes'],
            [2, 0, 1, 1, 'yes'],
            [2, 1, 0, 1, 'yes'],
            [2, 1, 0, 2, 'yes'],
            [2, 0, 0, 0, 'no']]
    labels = ['F1-AGE', 'F2-WORK', 'F3-HOME', 'F4-LOAN']
    return dataSet, labels

def createTree(dataset,labels,featLabels):#featLabels是按顺序排的每一个属性的先后节点顺序，
    classList = [example[-1] for example in dataset]#取最后一列标签
    if classList.count(classList[0]) == len(classList):
        return classList[0]#避免无限递归，跳出循环，当一列中所有相同的个数相加等于长度是，就退出
    if len(dataset[0]) == 1:
        return majorityCnt(classList)#当最后一个属性遍历完后，就跳出递归
    bestFeat = chooseBestFeatureToSplit(dataset)#在dataset中分离出一个最优的属性
    bestFeatLabel = labels[bestFeat]#找到最优属性的标签
    featLabels.append(bestFeatLabel)#append（）方法用于在列表末尾添加元素。
    myTree = {bestFeatLabel:{}}#字典key：value
    del labels[bestFeat]#将用过的属性的标签删去
    featValue = [example[bestFeat] for example in dataset]#取的是最优那一列的所有值
    uniqueVals = set(featValue)#去重
    for value in uniqueVals:
        sublabels = labels[:]
        myTree[bestFeatLabel][value] = createTree(splitDataSet(dataset,bestFeat,value),sublabels,featLabels)
        #也就是说根据当前属性划分为几个集合后，再将这几个集合中的数据进行循环递归，继续划分直到退出循环
    return myTree#最后将字典返回

def majorityCnt(classList):#将最后一列标签传进来了，也就是yes or no
    classCount={}#定义了一个字典
    for vote in classList:
        if vote not in classCount.keys():
            classCount[vote] = 0 #如果没有在 classCount.keys()，就将该值变为0
        classCount[vote] += 1#如果有就加一
    #统计每个键值出现的个数
    sortedclassCount = sorted(classCount.items(),key=operator.itemgetter(1),reverse=True)
    #将键值排序，表示对第一维的数据进行降序排列，items（）是取字典中每一个键和键值
    return sortedclassCount[0][0]
    #返回出现次数最多的名称

def chooseBestFeatureToSplit(dataset):
    #选择一个最优的属性从dataset中分离，按照熵值和信息增益来划分
    numFeatures = len(dataset[0]) - 1
    baseEntropy = calcShannonEnt(dataset)
    bestInfoGain = 0
    bestFeature = -1
    for i in range(numFeatures):
        #遍历每一列，并取出
        featList = [example[i] for example in dataset]
        uniqueVals = set(featList)
        newEntropy = 0
        for val in uniqueVals:
            subDataSet = splitDataSet(dataset,i,val)
            #切分数据集，subDataSet这里面就是之前在这一列中包含val值的多行，但是将val的值去掉了。
            #len(subDataSet)这个就是行数，其实就是在这一列中包含val的个数。
            prob = len(subDataSet)/float(len(dataset))
            newEntropy += prob * calcShannonEnt(subDataSet)
        infoGain = baseEntropy - newEntropy
        if (infoGain > bestInfoGain):
            bestInfoGain = infoGain
            bestFeature = i
    return bestFeature
    #返回最优的那一列的索引i
            

def splitDataSet(dataset,axis,val):
    #本函数应该是返回一个行数，一个在dataset中含val的行数，
    retDataSet = []
    for featVec in dataset:
        if featVec[axis] == val:
            #在这一行的第axis个数与val比较，并相同的值
            reducedFeatVec = featVec[:axis]
            reducedFeatVec.extend(featVec[axis+1:])
            #extend() 函数用于在列表末尾一次性追加另一个序列中的多个值(用新列表扩展原来的列表)
            retDataSet.append(reducedFeatVec)
            #就是将除去val的数的该行返回，即去掉该数后，并将行返回
            #append（）方法用于在列表末尾添加元素。
    return retDataSet

def calcShannonEnt(dataset):
    #计算熵值
    numexamples = len(dataset)
    #样本数量
    labelCounts = {}
    for featVec in dataset:
        currentlabel = featVec[-1]
        #取yes or no
        if currentlabel not in labelCounts.keys():
            labelCounts[currentlabel] = 0
        labelCounts[currentlabel] += 1
    #计算出yes or no的个数
    shannonEnt = 0
    for key in labelCounts:
        prop = float(labelCounts[key])/numexamples
        #计算概率
        shannonEnt -= prop*log(prop,2)
        #计算熵值
    return shannonEnt


def getNumLeafs(myTree):
    numLeafs = 0
    firstStr = next(iter(myTree))
    secondDict = myTree[firstStr]
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
            numLeafs += getNumLeafs(secondDict[key])
        else:   numLeafs +=1
    return numLeafs


def getTreeDepth(myTree):
    maxDepth = 0
    firstStr = next(iter(myTree))
    secondDict = myTree[firstStr]
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
               thisDepth = 1 + getTreeDepth(secondDict[key])
        else:   thisDepth = 1
        if thisDepth > maxDepth: maxDepth = thisDepth
    return maxDepth

def plotNode(nodeTxt, centerPt, parentPt, nodeType):
    arrow_args = dict(arrowstyle="<-")
    font = FontProperties(fname=r"c:\windows\fonts\simsunb.ttf", size=14)
    createPlot.ax1.annotate(nodeTxt, xy=parentPt,  xycoords='axes fraction',
        xytext=centerPt, textcoords='axes fraction',
        va="center", ha="center", bbox=nodeType, arrowprops=arrow_args, FontProperties=font)


def plotMidText(cntrPt, parentPt, txtString):
    xMid = (parentPt[0]-cntrPt[0])/2.0 + cntrPt[0]
    yMid = (parentPt[1]-cntrPt[1])/2.0 + cntrPt[1]
    createPlot.ax1.text(xMid, yMid, txtString, va="center", ha="center", rotation=30)


def plotTree(myTree, parentPt, nodeTxt):
    decisionNode = dict(boxstyle="sawtooth", fc="0.8")
    leafNode = dict(boxstyle="round4", fc="0.8")
    numLeafs = getNumLeafs(myTree)  
    depth = getTreeDepth(myTree)
    firstStr = next(iter(myTree))
    cntrPt = (plotTree.xOff + (1.0 + float(numLeafs))/2.0/plotTree.totalW, plotTree.yOff)
    plotMidText(cntrPt, parentPt, nodeTxt)
    plotNode(firstStr, cntrPt, parentPt, decisionNode)
    secondDict = myTree[firstStr]
    plotTree.yOff = plotTree.yOff - 1.0/plotTree.totalD
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
            plotTree(secondDict[key],cntrPt,str(key))       
        else:
            plotTree.xOff = plotTree.xOff + 1.0/plotTree.totalW
            plotNode(secondDict[key], (plotTree.xOff, plotTree.yOff), cntrPt, leafNode)
            plotMidText((plotTree.xOff, plotTree.yOff), cntrPt, str(key))
    plotTree.yOff = plotTree.yOff + 1.0/plotTree.totalD


def createPlot(inTree):
    fig = plt.figure(1, facecolor='white')#创建fig
    fig.clf()#清空fig
    axprops = dict(xticks=[], yticks=[])
    createPlot.ax1 = plt.subplot(111, frameon=False, **axprops) #去掉x、y轴
    plotTree.totalW = float(getNumLeafs(inTree))#获取决策树叶结点数目
    plotTree.totalD = float(getTreeDepth(inTree))#获取决策树层数
    plotTree.xOff = -0.5/plotTree.totalW; plotTree.yOff = 1.0;#x偏移
    plotTree(inTree, (0.5,1.0), '')#绘制决策树
    plt.show()




if __name__ == '__main__':
    dataset, labels = createDataSet()
    featLabels = []
    myTree = createTree(dataset,labels,featLabels)
    createPlot(myTree)
