---
name: leetcode-study-generator
description: Use when the user provides a LeetCode link, asks for high-frequency LeetCode problems by knowledge point, or asks to initialize or update a LeetCode study workspace, study folder, interactive HTML explanation, practice code file, runnable tests, or yearly problem-bank page.
---

# LeetCode Study Generator

## Purpose

Create and maintain a consistent LeetCode study workspace. Each problem gets a study `index.html`, a practice code file, runnable tests, and an entry in the yearly `leetcode-problem-bank.html` page.

Never assume the project directory, study directory, or practice language. Resolve them before generating problem files.

## Change Handling

When the user changes any generation rule, treat it as a workflow design change, not as an isolated patch request.

Before editing generated files or this skill:
1. Re-read the affected workflow sections end to end.
2. Update all dependent rules together: directory naming, HTML structure, code files, tests, commands, verification, and problem-bank indexing.
3. Remove or rewrite outdated wording that conflicts with the new rule.
4. Keep examples, file names, and commands aligned with the current rule set.

## Request Modes

Support these request forms:

1. **Single Problem Mode**: the user provides one LeetCode problem URL. Generate one problem folder.
2. **Knowledge Point Mode**: the user invokes `/leetcode-study-generator knowledge-point <知识点> [num]` or `/skill-name knowledge-point <知识点> [num]`. Find high-frequency LeetCode problems for that knowledge point, prefer problems not already present in the study directory, then generate one problem folder for each selected new problem.
3. **Review Reinitialization Mode**: when Knowledge Point Mode finds no uncompleted matching problems, ask the user whether to review completed problems from that knowledge point. If the user chooses problem(s), reset only the practice code/test portion for the chosen existing folder(s). Do not regenerate or overwrite the corresponding `index.html`.

Knowledge Point Mode parsing rules:
- Treat the final token as `num` only when it is a positive integer.
- If `num` is omitted, use `1`.
- Treat every token between `knowledge-point` and the optional final `num` as the knowledge point, so multi-word topics such as `binary search answer` still work.
- If `num` is larger than the number of confidently verified matching problems, generate only the verified problems and report the shortfall.
- A problem counts as already completed when its problem directory exists in the study directory or it is already indexed in `leetcode-problem-bank.html`.
- Select high-frequency uncompleted problems first. Skip completed problems while uncompleted verified candidates remain.
- If no uncompleted candidate remains, present up to five completed matching problems sorted by frequency, or all completed matching problems when fewer than five exist, and ask the user to choose which one(s) to review.
- In Review Reinitialization Mode, preserve `index.html` and problem-bank content. Reinitialize the practice code file to a hint-free skeleton and ensure runnable tests exist; do not rewrite the learning HTML unless the user explicitly asks for a full refresh.

## Execution Order

### 1. Inspect Project And Infer Language

1. Ask the user for the engineering/project directory.
2. Inspect it shallowly with `find <dir> -maxdepth 3 -type f` and `rg --files <dir>`.
3. Infer the common practice language from project signals:
   - Java: `pom.xml`, `build.gradle`, `.iml`, `src/main/java`, `src/com`, many `.java` files.
   - Python/Python3: `pyproject.toml`, `requirements.txt`, many `.py` files.
   - JavaScript/TypeScript: `package.json`, `tsconfig.json`, many `.js`, `.jsx`, `.ts`, or `.tsx` files.
   - Go: `go.mod`, many `.go` files.
   - C/C++: `CMakeLists.txt`, many `.c`, `.cc`, `.cpp`, `.h`, or `.hpp` files.
   - Rust: `Cargo.toml`, many `.rs` files.
4. If signals conflict or are weak, ask the user for the common LeetCode practice language.

### 2. Determine Study Directory

After identifying the project language, suggest a study directory and ask the user to accept it or specify another directory.

Recommended defaults:
- Java with `src/com`: `src/com/leetcodeYYYY`.
- Java with `src/main/java`: `src/main/java/leetcodeYYYY`.
- Python/Python3: `leetcode/YYYY`.
- JavaScript/TypeScript: `leetcode/YYYY`.
- Go: `leetcode/YYYY` unless the module has an established examples/practice layout.
- C++: `leetcode/YYYY`.

Rules:
- Use the current year unless the user specifies another year.
- Create the chosen study directory if needed.
- Do not write outside the user-approved project/study directory.
- Create or update `leetcode-problem-bank.html` in the study directory.
- Remember for the current task: project directory, study directory, common language, and source root if the language uses packages.

### 3. Resolve Requested Problems

For Single Problem Mode:
1. Extract the problem slug from the URL.
2. Continue with that single problem.

For Knowledge Point Mode:
1. Browse current LeetCode and reliable curated sources to identify high-frequency problems for the requested knowledge point. Prefer LeetCode China topic/tag pages, official lists such as 热题 100 or 面试经典, and widely accepted curated lists when official frequency data is not exposed.
2. Rank candidates by frequency signals: appearance across official/curated high-frequency lists, topic/tag match quality, interview-list presence, and community consensus.
3. Prefer classic representative problems that directly exercise the requested knowledge point over loosely related problems.
4. Verify each candidate's problem number, title, slug, URL, tags, examples, constraints, and official solution availability before generation.
5. Compare verified candidates with existing study folders and `leetcode-problem-bank.html` entries.
6. Select up to `num` high-frequency uncompleted verified problems, defaulting to `1` when omitted.
7. If fewer than `num` uncompleted problems are available, generate the available uncompleted problems and report the shortfall.
8. If zero uncompleted problems are available, present up to five completed verified candidates sorted by frequency, ask the user whether to review one or more of them, and wait for the user's choice before changing files.
9. Keep a short source note for the selection and include relevant links in each generated `index.html`.

### 4. Read And Verify Each LeetCode Problem

1. Extract the problem slug from the URL.
2. Browse or otherwise verify the problem number, title, examples, constraints, and tags when not already available locally.
3. Open the official solution when it exists. If the page does not expose it, search the slug plus `官方题解` or `LeetCode official solution`.
4. If no official solution is available, use a high-quality accepted editorial or standard optimal approach and state that it is not official.
5. Paraphrase official reasoning and link sources; do not copy long official text or large code blocks verbatim.

The generated explanation, reference implementation, tests, and complexity must not be worse than the official answer in correctness, edge cases, or asymptotic complexity.

For batch generation, apply the remaining steps to every selected new problem. Update `leetcode-problem-bank.html` once after all selected new problems have been generated or updated. For Review Reinitialization Mode, skip HTML generation and problem-bank updates; only reset practice code/test files for the chosen existing problem(s).

### 5. Create The Problem Directory

Use this directory name:

```text
<leetcode-slug-with-underscores>_<zero-padded-number>
```

Example:

```text
longest_substring_without_repeating_characters_003
```

For Java source/package trees, this directory name is a valid package segment; match the package statement to the directory path. Put all per-problem files in this directory. Do not leave standalone problem HTML files in the study directory root.

### 6. Generate `index.html`

Use the standardized HTML rules below for every problem, regardless of model.

Skip this step in Review Reinitialization Mode unless the user explicitly requests a full HTML refresh.

#### Required Structure

Use a single self-contained HTML file with these sections in this order:

1. Header with `LeetCode <number>：<Chinese title>` or the best localized title.
2. 题目概述.
3. 示例拆解.
4. 考察点.
5. 官方题解对比.
6. 解题思路.
7. 参考实现.
8. 核心变量/状态.
9. 执行过程可视化, when state changes are useful.
10. 易错点.
11. 复杂度分析.
12. 练习文件.
13. 来源链接.

#### Required Style

Keep visual style consistent:
- One self-contained `<style>` block; no external CSS or CDN.
- Use a restrained professional palette with CSS variables: `--bg`, `--panel`, `--ink`, `--muted`, `--line`, `--blue`, `--blue-soft`, `--green-soft`, `--orange-soft`.
- Body background `#f6f8fb`, white panels, 8px border radius, 1px borders.
- Header uses a blue-to-green linear gradient.
- Use `.wrap` with `width: min(1120px, calc(100% - 32px))`.
- Use full-width vertical sections, not nested cards or side-by-side decorative graph cards.
- Use responsive grids only for compact stat/example groups; collapse to one column on mobile.
- Keep fonts system-based: `-apple-system, BlinkMacSystemFont, "Segoe UI", "Microsoft YaHei", sans-serif`.

#### Reference Implementation Comments

The reference implementation inside `index.html` is for learning and must be well commented in the initialized common language.

For Java reference code:
- Add enough comments to explain key variables, invariants, branch decisions, and update timing.
- Comments should teach the core logic without becoming line-by-line noise.
- This rule applies only to the reference implementation in `index.html`.
- It does not apply to practice files; practice files must remain hint-free.

#### Content Rules

Include:
- Problem number, title, source link, and concise restatement.
- In Knowledge Point Mode, explain why this problem was selected for the requested knowledge point.
- Examples with output reasoning.
- Knowledge points and algorithm pattern.
- Official-solution comparison notes.
- Reasoning from brute force to optimized approach.
- Reference implementation in the initialized common language.
- Core variable/state explanation.
- Common mistakes and boundary cases.
- Time and space complexity.
- Practice file section with exact compile/test command.
- Link back to `../leetcode-problem-bank.html`.
- Problem source link and official solution link when available.

When the algorithm has evolving state, include a small plain HTML/CSS/JS visualization such as next-step and reset controls.

### 7. Generate Practice Code

Use the initialized common language.

General rules:
- Practice files must contain no hints, TODO comments, strategy notes, docstrings/Javadocs, or explanatory comments.
- Prefer a minimal stub that compiles/runs and fails tests clearly.
- Keep file names conventional for the selected language.
- In Review Reinitialization Mode, overwrite only the practice code file(s) for the chosen existing problem(s), preserving `index.html`.

Language conventions:
- Java: `Solution.java` or fixed LeetCode class name such as `LRUCache.java`; legal package statement when under a source root; type-correct stub values.
- Python/Python3: `solution.py`; `class Solution:` with LeetCode-required method signature; Python 3 syntax; type hints when useful.
- Go: `solution.go`; `package main` for standalone folders unless project convention says otherwise; LeetCode-style function names.
- C++: `solution.cpp`; minimal standard headers; `class Solution` with public LeetCode method.
- JavaScript: `solution.js`; LeetCode-style function/class; export with `module.exports` so tests can import it.

### 8. Generate Runnable Tests

Use no external test framework unless the project already has one and the user wants it.

Test cases must include official examples, empty/minimal input, repeated values, and cases that catch common pointer, stale state, and boundary bugs.

Language-specific test files and commands:
- Java: `SolutionTest.java` or `<ClassName>Test.java`; use `main` and explicit assertions; run from the Java source root with `javac ... && java fully.qualified.TestClass`.
- Python/Python3: `test_solution.py`; use `unittest`; run `python3 test_solution.py`.
- Go: `solution_test.go`; use Go's `testing` package; run `go test`.
- C++: `solution_test.cpp`; use a small `main` with assertions; compile with `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `solution.test.js`; use Node's built-in `assert`; run `node solution.test.js`.

Include a short timeout guard when practical so loop bugs fail clearly instead of hanging.

In Review Reinitialization Mode, preserve existing runnable tests when they already match the current problem signature. Recreate tests only when missing, broken, or inconsistent with the current language conventions.

### 9. Record Commands In HTML

The `index.html` practice section must show the exact command for the selected language:
- Java: run from source root, for example `javac com/leetcode2026/problem_name_000/Solution.java com/leetcode2026/problem_name_000/SolutionTest.java && java com.leetcode2026.problem_name_000.SolutionTest`.
- Python/Python3: `python3 test_solution.py`.
- Go: `go test`.
- C++: `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `node solution.test.js`.

Skip this step in Review Reinitialization Mode because `index.html` must not be rewritten.

### 10. Update `leetcode-problem-bank.html`

The page title and H1 must be `LeetCode 题库`.

The page must contain exactly these major content parts:
1. **进度**: total problems, covered 考察点 count, highest topic frequency, and total runnable test cases.
2. **考察点目录**: topics sorted by problem frequency descending; include topic name, frequency, and linked problem titles.
3. **考察点**: one vertical section per topic, with method overview/rule pattern and its own problem index.

Do not show an `更新规则` section. Do not use side-by-side graph cards. Preserve existing entries, recompute frequencies from all indexed problems, and use stable existing order for ties.

Skip this step in Review Reinitialization Mode unless the chosen problem is missing from the problem bank and the user explicitly asks to repair indexing.

### 11. Verify And Clean Up

1. Run the language-appropriate compile/test command from the correct working directory.
2. If the practice file is intentionally a skeleton, the test run should fail clearly on an expected case; report that as expected.
3. If a completed implementation was requested, all tests must pass.
4. Remove generated build artifacts such as `.class`, C++ binaries, or temporary caches.
5. Verify HTML links and required sections, especially the link back to `leetcode-problem-bank.html`.
6. Compare the explanation, reference implementation, tests, and complexity against official solution notes before finishing.

## Safety Rules

- Preserve user edits in existing problem files; read before modifying.
- Update existing problem folders instead of creating duplicates.
- Keep edits scoped to the study directory and skill files.
- Do not commit unless the user asks.
- Do not leave temporary servers running.
