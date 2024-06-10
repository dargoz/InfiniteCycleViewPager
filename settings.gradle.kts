pluginManagement {
    repositories {
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/RepositoryMBI/")
            isAllowInsecureProtocol  = true
            credentials {
                username = "mbi"
                password = "Bcabca123!"
            }
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/Repo1Maven/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/Repo2Maven/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/plugins.gradle.org/")
            isAllowInsecureProtocol  = true
        }

        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/maven.google.com/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/developer.huawei.com/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/jitpack.io/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/RepositoryDevOps/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/jcenter.bintray.com/")
            isAllowInsecureProtocol  = true
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/RepositoryMBI/")
            isAllowInsecureProtocol  = true
            credentials {
                username = "mbi"
                password = "Bcabca123!"
            }
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/Repo1Maven/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/Repo2Maven/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/plugins.gradle.org/")
            isAllowInsecureProtocol  = true
        }

        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/maven.google.com/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/developer.huawei.com/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/jitpack.io/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/RepositoryDevOps/")
            isAllowInsecureProtocol  = true
        }
        maven {
            url = uri("http://bcaartifactory:8080/artifactory/list/jcenter.bintray.com/")
            isAllowInsecureProtocol  = true
        }
    }
}

rootProject.name = "InfiniteCycleViewPager"
include(":app")
include(":infinitecycleviewpager")
