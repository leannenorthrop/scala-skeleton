# Scala Skeleton

Based on [this](https://github.com/fractal/skeleton). This project aims to simplify creating a project from scratch, ready to use without requiring g8 or activator. It provides a simple way to have a project running with the following tools configured:

     Scala 2.12.1
     SBT 0.13.13
     ScalaTest 3.0.1
     ScalaCheck 1.12.5
     Jenkins (test Reporting and code coverage)
     ScalaStyle

## Requirements

* Please download latest version of SBT at [sbt 0.13.13](http://www.scala-sbt.org)

## Usage

Clone and update the project name from build.sbt

```
$ git clone git://github.com/leannenorthrop/scala-skeleton my-project
$ cd my-project
$ rm -rf .git
$ vi build.sbt # change name to my-project, and organization to something that suits you
$ sbt
> test
```

## Test

The best feature of SBT is incremental compilation. This is most evident when testing.

```
> ~test
```

Be warned, it's addictive. You'll never want to code in any other statically compiled language without this feature.

Test a single TestSuite

```
> test-only package.subpackage.Class
```

### Test and Jenkins

ScalaTest is been configured to produce test reports in the JUnit XML format that Jenkins can understand in target/junit-xml-reports.
Configure Jenkins to use this folder. For many more options to configure, use the [ScalaTest runner documentation](http://www.scalatest.org/user_guide/using_the_runner)

### Integration Test

Abbreviated as it. A bit fiddly, since it will require every setting defined for test to also be defined for it.

```
> it:test
```

## Useful SBT Console commands

```
> console
> run
```

The former will run a scala REPL with all the project dependencies available. The later will autoscan and run a Main class.

## Code Coverage
Uses Scoverage as a code coverage tool. The main advantage over other coverage tools is that it understands expressions, as opposed to lines.

```
> test
> coverageReport
```

See [Scoverage Plugin](https://github.com/scoverage/sbt-scoverage)

Read documentation details, specially if using integration tests.

## Style Checker

Uses [ScalaStyle](http://www.scalastyle.org)

```
> scalastyle
```

## SBT Launch useful configuration options

Some of these configuration options are quite important to know when setting up a project behind a company proxy.
Configure then in your ~/.sbt/conf/sbtconfig.txt or sbtopts

	# Reserver a decent amount of memory for the SBT JVM  

	-Xms256M

	-Xmx2048M

	-XX:ReservedCodeCacheSize=128m

	# Set additional SBT options and HTTP Proxies if needed

	# -Dsbt.ivy.home=<m2 repo>

	-Dsbt.log.format=true

	# -Dhttp.proxyHost=<your_proxy_host>

	# -Dhttp.proxyPort=<your_proxy_port>

	# -Dhttp.nonProxyHosts="<dont_use_proxy_for_these_addresses>"
