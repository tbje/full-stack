fullOptJS problem with ZonedDateTime
------------------------------------

When moving to sjs 1.x I ran into the issue

compile and fastOptJS works well.

```
sbt:full-stack> last client/fullOptJS
[info] Full optimizing /home/tbje/proj/full-stack/js/target/scala-2.13/client-opt.js
[debug] Linker: Compute reachability: 447619 us
[debug] Linker: Assemble LinkedClasses: 32454 us
[debug] Linker: Check IR: 422904 us
[debug] Linker: 933965 us
[debug] Optimizer: Batch mode: true
[debug] Optimizer: Incremental part: 106715 us
[debug] Optimizer: Optimizing 5886 methods.
[debug] Optimizer: Optimizer part: 2042461 us
[debug] Optimizer: 2161914 us
[debug] Refiner: Compute reachability: 122983 us
[debug] Refiner: Assemble LinkedClasses: 8261 us
[debug] Refiner: 147066 us
[debug] Emitter: Generate classes: 746186 us
[debug] Emitter: Write trees: 19139 us
[debug] Emitter: Class tree cache stats: reused: 945 -- invalidated: 962
[debug] Emitter: Method tree cache stats: reused: 0 -- invalidated: 3789
[debug] Emitter: 811775 us
[debug] Closure: Create trees): 497838 us
[info] Closure: 0 error(s), 0 warning(s)
[error] java.lang.RuntimeException: INTERNAL COMPILER ERROR.
[error] Please report this problem.
[error]
[error] An enclosing scope is required for change reports but node NAME node$jscomp$inline_2106 114 [originalname: node] [source_file: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] [input_id: InputId: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] doesn't have one.
[error]   Node(BLOCK): https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala:112:37
[error] [source unknown]
[error]   Parent(BLOCK): https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashSet.scala:43:20
[error] [source unknown]
[error]
[error] 	at com.google.javascript.jscomp.Compiler.getChangeScopeForNode(Compiler.java:2560)
[error] 	at com.google.javascript.jscomp.Compiler.reportChangeToEnclosingScope(Compiler.java:2607)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineValue(InlineVariables.java:395)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineWellDefinedVariable(InlineVariables.java:344)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineNonConstants(InlineVariables.java:265)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.doInlinesForScope(InlineVariables.java:180)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.afterExitScope(InlineVariables.java:124)
[error] 	at com.google.javascript.jscomp.ReferenceCollectingCallback.exitScope(ReferenceCollectingCallback.java:262)
[error] 	at com.google.javascript.jscomp.NodeTraversal.popScope(NodeTraversal.java:1048)
[error] 	at com.google.javascript.jscomp.NodeTraversal.popScope(NodeTraversal.java:1039)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:855)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseFunction(NodeTraversal.java:900)
[error] 	at com.google.javascript.jscomp.NodeTraversal.handleFunction(NodeTraversal.java:806)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:832)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.handleScript(NodeTraversal.java:794)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:829)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseRoots(NodeTraversal.java:397)
[error] 	at com.google.javascript.jscomp.ReferenceCollectingCallback.process(ReferenceCollectingCallback.java:111)
[error] 	at com.google.javascript.jscomp.InlineVariables.process(InlineVariables.java:88)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer$NamedPass.process(PhaseOptimizer.java:317)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer$Loop.process(PhaseOptimizer.java:462)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer.process(PhaseOptimizer.java:232)
[error] 	at com.google.javascript.jscomp.Compiler.performOptimizations(Compiler.java:2418)
[error] 	at com.google.javascript.jscomp.Compiler.lambda$stage2Passes$1(Compiler.java:799)
[error] 	at com.google.javascript.jscomp.CompilerExecutor$2.call(CompilerExecutor.java:102)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
[error] 	at java.base/java.lang.Thread.run(Thread.java:834)
[error] Caused by: java.lang.IllegalStateException: An enclosing scope is required for change reports but node NAME node$jscomp$inline_2106 114 [originalname: node] [source_file: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] [input_id: InputId: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] doesn't have one.
[error] 	at com.google.javascript.jscomp.Compiler.getChangeScopeForNode(Compiler.java:2560)
[error] 	at com.google.javascript.jscomp.Compiler.reportChangeToEnclosingScope(Compiler.java:2607)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineValue(InlineVariables.java:395)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineWellDefinedVariable(InlineVariables.java:344)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.inlineNonConstants(InlineVariables.java:265)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.doInlinesForScope(InlineVariables.java:180)
[error] 	at com.google.javascript.jscomp.InlineVariables$InliningBehavior.afterExitScope(InlineVariables.java:124)
[error] 	at com.google.javascript.jscomp.ReferenceCollectingCallback.exitScope(ReferenceCollectingCallback.java:262)
[error] 	at com.google.javascript.jscomp.NodeTraversal.popScope(NodeTraversal.java:1048)
[error] 	at com.google.javascript.jscomp.NodeTraversal.popScope(NodeTraversal.java:1039)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:855)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseFunction(NodeTraversal.java:900)
[error] 	at com.google.javascript.jscomp.NodeTraversal.handleFunction(NodeTraversal.java:806)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:832)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.handleScript(NodeTraversal.java:794)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:829)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseChildren(NodeTraversal.java:989)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseBranch(NodeTraversal.java:857)
[error] 	at com.google.javascript.jscomp.NodeTraversal.traverseRoots(NodeTraversal.java:397)
[error] 	at com.google.javascript.jscomp.ReferenceCollectingCallback.process(ReferenceCollectingCallback.java:111)
[error] 	at com.google.javascript.jscomp.InlineVariables.process(InlineVariables.java:88)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer$NamedPass.process(PhaseOptimizer.java:317)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer$Loop.process(PhaseOptimizer.java:462)
[error] 	at com.google.javascript.jscomp.PhaseOptimizer.process(PhaseOptimizer.java:232)
[error] 	at com.google.javascript.jscomp.Compiler.performOptimizations(Compiler.java:2418)
[error] 	at com.google.javascript.jscomp.Compiler.lambda$stage2Passes$1(Compiler.java:799)
[error] 	at com.google.javascript.jscomp.CompilerExecutor$2.call(CompilerExecutor.java:102)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
[error] 	at java.base/java.lang.Thread.run(Thread.java:834)
[error] (client / Compile / fullOptJS) INTERNAL COMPILER ERROR.
[error] Please report this problem.
[error]
[error] An enclosing scope is required for change reports but node NAME node$jscomp$inline_2106 114 [originalname: node] [source_file: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] [input_id: InputId: https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala] doesn't have one.
[error]   Node(BLOCK): https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashMap.scala:112:37
[error] [source unknown]
[error]   Parent(BLOCK): https://raw.githubusercontent.com/scala-js/scala-js/v1.1.0/javalib/src/main/scala/java/util/HashSet.scala:43:20
[error] [source unknown]
```
