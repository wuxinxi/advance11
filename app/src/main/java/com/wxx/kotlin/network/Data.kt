package com.wxx.kotlin.network

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:一句话描述
 */

data class Data(
    val children: Any,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Long,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)


data class Article(
    val curPage: Int,
    val datas: List<Project>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class Project(
    val apkLink: String?,
    val audit: Int,
    val author: String,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val envelopePic: String,
    val fresh: Boolean,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String?,
    val prefix: String?,
    val projectLink: String,
    val publishTime: Long,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String?,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Tag>,
    val title: String,
    val type: Int,
    val visible: Int,
    val zan: Int

)

data class Tag(
    val name: String,
    val url: String
)

data class DJango(val data: String)