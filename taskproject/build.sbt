name := """TaskProject"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "7.16.2"
