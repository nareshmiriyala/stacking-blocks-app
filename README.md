# Stacking Blocks App

This application stacks given n blocks where the dimensions of the i th block is blocks[i]
= [width[i], length[i], height[i]] (0-indexed). Choose a subset of blocks and place them on each other. You can place block i
on block j if width[i] <= width[j] and length[i] <= length[j] and height[i] <= height[j]. You can rearrange any blocks's dimensions
by rotating it to put it on another block. Return the maximum height of the stacked blocks.

###Example 

####Input: blocks = [[50,45,20],[95,37,53],[45,23,12]]
####Output: 190
