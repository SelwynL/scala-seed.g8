logLevel :=  Level.Info

lazy val root = project.in(file("."))
  .settings(
    organization  :=  "$organization$",
    name          :=  "$name$",
    version       :=  "$projectVersion$",
    scalaVersion  :=  "$scalaVersion$",
    description   :=  "$desc$",
    scalacOptions :=  BuildSettings.compilerOptions,
    scalacOptions in  (Compile, console) ~= { _.filterNot(Set("-Ywarn-unused-import")) },
    scalacOptions in  (Test, console)    := (scalacOptions in (Compile, console)).value,
    javacOptions  :=  BuildSettings.javaCompilerOptions,
    resolvers     ++= Dependencies.resolutionRepos,
    shellPrompt   :=  { _ => "$name$> "}
  )
  .settings(BuildSettings.wartremoverSettings)
  .settings(BuildSettings.scalaFmtSettings)
  .settings(BuildSettings.scalifySettings)
  .settings(BuildSettings.sbtAssemblySettings)
  .settings(
    libraryDependencies ++= Dependencies.Libraries
  )
