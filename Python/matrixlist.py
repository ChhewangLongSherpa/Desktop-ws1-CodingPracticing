# -*- coding: utf-8 -*-
"""
Created on Tue Feb 23 17:29:39 2016

@author: Shop
"""

import numpy as np

x = np.random.randint(1000,size=(3,4))

def null_list(Alist):
        ranks = []
        null = []
        ranks.append(len(Alist[0]))
        null.append(len(Alist) - len(Alist[0])) 
        # for m x n matrix, n = rank(n) + null(n)
        # where rank is the dimension of its row space