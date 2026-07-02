---
name: leetcode-study-generator
description: Use when the user provides a LeetCode link or asks to initialize or update a LeetCode study workspace, study folder, interactive HTML explanation, practice code file, runnable tests, or a yearly problem-bank page.
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

### 3. Read And Verify The LeetCode Problem

1. Extract the problem slug from the URL.
2. Browse or otherwise verify the problem number, title, examples, constraints, and tags when not already available locally.
3. Open the official solution when it exists. If the page does not expose it, search the slug plus `官方题解` or `LeetCode official solution`.
4. If no official solution is available, use a high-quality accepted editorial or standard optimal approach and state that it is not official.
5. Paraphrase official reasoning and link sources; do not copy long official text or large code blocks verbatim.

The generated explanation, reference implementation, tests, and complexity must not be worse than the official answer in correctness, edge cases, or asymptotic complexity.

### 4. Create The Problem Directory

Use this directory name:

```text
<leetcode-slug-with-underscores>_<zero-padded-number>
```

Example:

```text
longest_substring_without_repeating_characters_003
```

For Java source/package trees, this directory name is a valid package segment; match the package statement to the directory path. Put all per-problem files in this directory. Do not leave standalone problem HTML files in the study directory root.

### 5. Generate `index.html`

Use the standardized HTML rules below for every problem, regardless of model.

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

### 6. Generate Practice Code

Use the initialized common language.

General rules:
- Practice files must contain no hints, TODO comments, strategy notes, docstrings/Javadocs, or explanatory comments.
- Prefer a minimal stub that compiles/runs and fails tests clearly.
- Keep file names conventional for the selected language.

Language conventions:
- Java: `Solution.java` or fixed LeetCode class name such as `LRUCache.java`; legal package statement when under a source root; type-correct stub values.
- Python/Python3: `solution.py`; `class Solution:` with LeetCode-required method signature; Python 3 syntax; type hints when useful.
- Go: `solution.go`; `package main` for standalone folders unless project convention says otherwise; LeetCode-style function names.
- C++: `solution.cpp`; minimal standard headers; `class Solution` with public LeetCode method.
- JavaScript: `solution.js`; LeetCode-style function/class; export with `module.exports` so tests can import it.

### 7. Generate Runnable Tests

Use no external test framework unless the project already has one and the user wants it.

Test cases must include official examples, empty/minimal input, repeated values, and cases that catch common pointer, stale state, and boundary bugs.

Language-specific test files and commands:
- Java: `SolutionTest.java` or `<ClassName>Test.java`; use `main` and explicit assertions; run from the Java source root with `javac ... && java fully.qualified.TestClass`.
- Python/Python3: `test_solution.py`; use `unittest`; run `python3 test_solution.py`.
- Go: `solution_test.go`; use Go's `testing` package; run `go test`.
- C++: `solution_test.cpp`; use a small `main` with assertions; compile with `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `solution.test.js`; use Node's built-in `assert`; run `node solution.test.js`.

Include a short timeout guard when practical so loop bugs fail clearly instead of hanging.

### 8. Record Commands In HTML

The `index.html` practice section must show the exact command for the selected language:
- Java: run from source root, for example `javac com/leetcode2026/problem_name_000/Solution.java com/leetcode2026/problem_name_000/SolutionTest.java && java com.leetcode2026.problem_name_000.SolutionTest`.
- Python/Python3: `python3 test_solution.py`.
- Go: `go test`.
- C++: `g++ -std=c++17 solution.cpp solution_test.cpp -o solution_test && ./solution_test`.
- JavaScript: `node solution.test.js`.

### 9. Update `leetcode-problem-bank.html`

The page title and H1 must be `LeetCode 题库`.

The page must contain exactly these major content parts:
1. **进度**: total problems, covered 考察点 count, highest topic frequency, and total runnable test cases.
2. **考察点目录**: topics sorted by problem frequency descending; include topic name, frequency, and linked problem titles.
3. **考察点**: one vertical section per topic, with method overview/rule pattern and its own problem index.

Do not show an `更新规则` section. Do not use side-by-side graph cards. Preserve existing entries, recompute frequencies from all indexed problems, and use stable existing order for ties.

### 10. Verify And Clean Up

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
